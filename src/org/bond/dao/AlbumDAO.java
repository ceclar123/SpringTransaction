package org.bond.dao;

import java.util.List;

import org.bond.entity.AlbumEntity;
import org.bond.entity.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumDAO extends BaseDAO<AlbumEntity> {
	/**
	 * ��ȡ������Ϣ
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AlbumEntity> getAllList() {
		String hql = "from AlbumEntity";
		Session session = getSession();
		return session.createQuery(hql).list();
	}

	public AlbumEntity get(long id) {
		String hql = "from AlbumEntity where id=" + id;
		Session session = getSession();
		List<AlbumEntity> list = session.createQuery(hql).list();
		if (list != null) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * ��ȡ������
	 * 
	 * @return
	 */
	public Long getTotalCount() {
		Session session = getNewSession();
		String hql = "select count(*) from AlbumEntity";
		Long count = (Long) session.createQuery(hql).uniqueResult();

		return count != null ? count.longValue() : 0;
	}

	/**
	 * �����������
	 * 
	 * @param list
	 */
	public void save(List<AlbumEntity> list) {
		Session session = getNewSession();
		for (AlbumEntity bean : list) {
			session.save(bean);
		}

	}

	/*
	 * �����������
	 */
	public void save(AlbumEntity... list) {
		Session session = getNewSession();
		for (AlbumEntity bean : list) {
			session.save(bean);
		}

	}
}
