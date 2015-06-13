package org.bond.hibernate.service.impl;

import org.bond.entity.AlbumEntity;
import org.bond.entity.UserEntity;
import org.bond.exception.NoRollbackException;
import org.bond.hibernate.service.IAlbumService;
import org.bond.hibernate.service.IUserAlbumService;
import org.bond.hibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAlbumService implements IUserAlbumService {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAlbumService albumService;

	@Override
	public void setNameDesc(String newName, String newDesc) {
		try {
			// 更新人
			UserEntity user = new UserEntity();
			user.setId(1);
			user.setLoginName("root");
			user.setUserName(newName);
			user.setPassword("123");
			user.setMd5psd("202CB962AC59075B964B07152D234B70");
			userService.update(user);
		} catch (NoRollbackException e) {
			System.out.println("UserAlbumService不会滚:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("UserAlbumService回滚:" + e.getMessage());
		}

		// 更新相册
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1);
		albumEntity.setUserID(1);
		albumEntity.setAlbumName(newDesc);
		albumEntity.setAlbumDesc(newDesc);
		albumService.update(albumEntity);

	}
}
