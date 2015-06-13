package org.bond.hibernate.service;

import java.util.List;

import org.bond.entity.UserEntity;
import org.bond.exception.NoRollbackException;

public interface IUserService {
	public UserEntity getObject(long id);

	public void save(UserEntity bean);

	public void save(List<UserEntity> list);

	public void save(UserEntity... list);

	public void update(UserEntity bean) throws NoRollbackException, Exception;

	public void delete(UserEntity bean);

	public void delete(String id);

	public void delete(String[] ids);
}
