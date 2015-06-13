package org.bond.dao;

import java.util.List;

import org.bond.entity.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends BaseDAO<UserEntity> {

	/**
	 * 获取所有信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllList() {
		String hql = "from UserEntity";
		Session session = getSession();
		return session.createQuery(hql).list();
	}

	public UserEntity get(long id) {
		String hql = "from UserEntity where id=" + id;
		Session session = getSession();
		List<UserEntity> list = session.createQuery(hql).list();
		if (list != null) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * 获取总数量
	 * 
	 * @return
	 */
	public Long getTotalCount() {
		Session session = getNewSession();
		String hql = "select count(*) from UserEntity";
		Long count = (Long) session.createQuery(hql).uniqueResult();

		return count != null ? count.longValue() : 0;
	}

	/**
	 * 批量添加数据
	 * 
	 * @param list
	 */
	public void save(List<UserEntity> list) {
		Session session = getNewSession();
		for (UserEntity bean : list) {
			session.save(bean);
		}

	}

	/*
	 * 批量添加数据
	 */
	public void save(UserEntity... list) {
		Session session = getNewSession();
		for (UserEntity bean : list) {
			session.save(bean);
		}

	}
}
