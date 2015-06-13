package org.bond.test;

import org.bond.jdbc.service.IPurchaseService;
import org.bond.jdbc.service.impl.PurchaseServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring-jdbc.xml");

		IPurchaseService service = appContext
				.getBean(PurchaseServiceImpl.class);

		// IPurchase service = (IPurchase) appContext.getBean("purchase");

		service.purchase();

		System.out.println("操作成功,没有报错");
	}

}
