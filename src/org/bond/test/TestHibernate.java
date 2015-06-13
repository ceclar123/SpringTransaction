package org.bond.test;

import org.bond.entity.AlbumEntity;
import org.bond.entity.UserEntity;
import org.bond.exception.NoRollbackException;
import org.bond.hibernate.service.IAlbumService;
import org.bond.hibernate.service.IUserService;
import org.bond.hibernate.service.impl.AlbumService;
import org.bond.hibernate.service.impl.UserAlbumService;
import org.bond.hibernate.service.impl.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {

	public static void main(String[] args) {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext(
					"spring-hibernate.xml");

			// ����Ƕ��
			// UserAlbumService userAlbumService = appContext
			// .getBean(UserAlbumService.class);
			// userAlbumService.setNameDesc("����XX", "����XX");

			IAlbumService albumService = appContext.getBean(AlbumService.class);

			// ������
			UserEntity userEntity = new UserEntity();
			userEntity.setId(1);
			userEntity.setLoginName("root");
			userEntity.setUserName("���Ŵ�ѩ");
			userEntity.setPassword("123");
			userEntity.setMd5psd("202CB962AC59075B964B07152D234B70");

			// �������
			AlbumEntity albumEntity = new AlbumEntity();
			albumEntity.setId(0);
			albumEntity.setUserID(1);
			albumEntity.setAlbumName("���Ŵ�ѩ");
			albumEntity.setAlbumDesc("���Ŵ�ѩ");

			albumService.update(userEntity, albumEntity);

		} catch (NoRollbackException e) {
			// System.out.println("Test:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// System.out.println("Test:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
