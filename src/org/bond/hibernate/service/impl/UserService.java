package org.bond.hibernate.service.impl;

import java.util.List;

import org.bond.dao.UserDAO;
import org.bond.entity.UserEntity;
import org.bond.exception.NoRollbackException;
import org.bond.hibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
	@Autowired
	UserDAO userDAO;

	public UserEntity getObject(long id) {
		return userDAO.getObject(id);
	}

	/**
	 * 保存
	 * 
	 * @param bean
	 * 
	 */
	public void save(UserEntity bean) {
		userDAO.save(bean);
	}

	/*
	 * 批量添加数据
	 */
	public void save(List<UserEntity> list) {
		userDAO.save(list);
	}

	/*
	 * 批量添加数据
	 */
	public void save(UserEntity... list) {
		userDAO.save(list);
	}

	/**
	 * 更新
	 * 
	 * @param bean
	 * 
	 */
	public void update(UserEntity bean) throws NoRollbackException, Exception {
		// userDAO.update(bean);
		throw new NoRollbackException("不回滚事务");
		// throw new Exception("回滚事务");

	}

	/**
	 * 删除
	 * 
	 * @param bean
	 * 
	 */
	public void delete(UserEntity bean) {
		userDAO.delete(bean);
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
		userDAO.delete(id);
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
		userDAO.delete(ids);
	}
}
