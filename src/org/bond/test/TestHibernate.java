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

			// 服务嵌套
			// UserAlbumService userAlbumService = appContext
			// .getBean(UserAlbumService.class);
			// userAlbumService.setNameDesc("李四XX", "李四XX");

			IAlbumService albumService = appContext.getBean(AlbumService.class);

			// 更新人
			UserEntity userEntity = new UserEntity();
			userEntity.setId(1);
			userEntity.setLoginName("root");
			userEntity.setUserName("西门吹雪");
			userEntity.setPassword("123");
			userEntity.setMd5psd("202CB962AC59075B964B07152D234B70");

			// 更新相册
			AlbumEntity albumEntity = new AlbumEntity();
			albumEntity.setId(0);
			albumEntity.setUserID(1);
			albumEntity.setAlbumName("西门吹雪");
			albumEntity.setAlbumDesc("西门吹雪");

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
