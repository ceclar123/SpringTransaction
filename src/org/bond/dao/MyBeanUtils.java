package org.bond.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBeanUtils extends BeanUtils {
	public static List<String> getObjectNotNullAttrNames(Object obj)
			throws Exception {
		List<String> results = null;
		Field[] fields = obj.getClass().getDeclaredFields();
		String keyList = "";
		String valueList = "";
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(obj) != null
					&& !"".equals(field.get(obj).toString().trim())) {
				if (results == null) {
					results = new ArrayList<String>();
				}
				results.add(field.getName());
			}
		}
		return results;
	}

	public static void copyProperties(Object source, Object target)
			throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(
						source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass()
								.getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod
									.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
					} catch (Throwable ex) {
						throw new FatalBeanException(
								"Could not copy properties from source to target",
								ex);
					}
				}
			}
		}
	}

	public static List<Map> listToKey_ValueList(List datas, Class orgClass,
			String key, String value) {
		List<Map> retList = null;
		try {
			if (datas != null && datas.size() > 0) {
				retList = new ArrayList<Map>();
				for (int i = 0, j = datas.size(); i < j; i++) {
					Object data = datas.get(i);
					BeanInfo beanInfo = Introspector.getBeanInfo(orgClass);
					PropertyDescriptor[] pds = beanInfo
							.getPropertyDescriptors();
					int size = 0;
					Map codeMap = new HashMap();
					for (PropertyDescriptor pd : pds) {
						if (pd.getName().equals(key)) {
							size++;
							codeMap.put("key", pd.getReadMethod().invoke(data));
						}
						if (pd.getName().equals(value)) {
							size++;
							codeMap.put("value", pd.getReadMethod()
									.invoke(data));
						}
						if (size >= 2) {
							break;
						}
					}
					retList.add(codeMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}
}
