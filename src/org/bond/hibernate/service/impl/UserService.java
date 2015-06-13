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
	 * ����
	 * 
	 * @param bean
	 * 
	 */
	public void save(UserEntity bean) {
		userDAO.save(bean);
	}

	/*
	 * �����������
	 */
	public void save(List<UserEntity> list) {
		userDAO.save(list);
	}

	/*
	 * �����������
	 */
	public void save(UserEntity... list) {
		userDAO.save(list);
	}

	/**
	 * ����
	 * 
	 * @param bean
	 * 
	 */
	public void update(UserEntity bean) throws NoRollbackException, Exception {
		// userDAO.update(bean);
		throw new NoRollbackException("���ع�����");
		// throw new Exception("�ع�����");

	}

	/**
	 * ɾ��
	 * 
	 * @param bean
	 * 
	 */
	public void delete(UserEntity bean) {
		userDAO.delete(bean);
	}

	/**
	 * ����IDɾ��
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
	 * ����ɾ��
	 * 
	 * 
	 * 
	 * @param ids
	 *            ID ����
	 * 
	 */
	public void delete(String[] ids) {
		userDAO.delete(ids);
	}
}
