package org.bond.hibernate.service.impl;

import java.util.List;

import org.bond.dao.AlbumDAO;
import org.bond.dao.UserDAO;
import org.bond.entity.AlbumEntity;
import org.bond.entity.UserEntity;
import org.bond.hibernate.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumService implements IAlbumService {
	@Autowired
	AlbumDAO albumDAO;
	@Autowired
	UserDAO userDAO;

	public AlbumEntity getObject(long id) {
		return albumDAO.getObject(id);
	}

	/**
	 * ����
	 * 
	 * @param bean
	 * 
	 */
	public void save(AlbumEntity bean) {
		albumDAO.save(bean);
	}

	/*
	 * �����������
	 */
	public void save(List<AlbumEntity> list) {
		albumDAO.save(list);
	}

	/*
	 * �����������
	 */
	public void save(AlbumEntity... list) {
		albumDAO.save(list);
	}

	/**
	 * ����
	 * 
	 * @param bean
	 * 
	 */
	public void update(AlbumEntity bean) {
		albumDAO.update(bean);

	}

	public void update(UserEntity user, AlbumEntity album) {
		userDAO.update(user);
		albumDAO.update(album);
	}

	/**
	 * ɾ��
	 * 
	 * @param bean
	 * 
	 */
	public void delete(AlbumEntity bean) {
		albumDAO.delete(bean);
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
		albumDAO.delete(id);
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
		albumDAO.delete(ids);
	}
}
