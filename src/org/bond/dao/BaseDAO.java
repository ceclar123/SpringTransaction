package org.bond.dao;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

import org.bond.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseDAO<T> extends BaseEntity {
	private Class<T> entityClass;
	/**
	 * Autowired 自动装配 相当于get,set;配置文件中对应的id
	 */
	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * 通过反射获取子类确定的泛型类
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDAO() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/**
	 * gerCurrentSession 会自动关闭session，使用的是当前的session事务
	 * 
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * openSession 需要手动关闭session 意思是打开一个新的session
	 * 
	 * @return
	 */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	 * 根据 id 查询信息
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getObject(long id) {
		Session session = getSession();
		return (T) session.get(entityClass, id);
	}

	/**
	 * 保存
	 * 
	 * @param bean
	 * 
	 */
	public void save(T bean) {
		Session session = getSession();
		session.save(bean);
	}

	/**
	 * 更新
	 * 
	 * @param bean
	 * 
	 */
	public void update(T bean) {
		Session session = getSession();
		BaseEntity entity = (BaseEntity) bean;
		T target = (T) session.get(bean.getClass(), entity.getId());
		MyBeanUtils.copyProperties(bean, target);
		session.merge(target);
	}

	/**
	 * 删除
	 * 
	 * @param bean
	 * 
	 */
	public void delete(T bean) {
		Session session = getSession();
		session.delete(bean);
	}

	/**
	 * 根据ID删除
	 * 
	 * 
	 * 
	 * @param id
	 *            ID
	 * 
	 */
	public void delete(String id) {
		Session session = getSession();
		Object obj = session.get(entityClass, id);
		session.delete(obj);
	}

	/**
	 * 批量删除
	 * 
	 * 
	 * 
	 * @param ids
	 *            ID 集合
	 * 
	 */
	public void delete(String[] ids) {
		for (String id : ids) {
			Object obj = getSession().get(entityClass, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
	}

}
