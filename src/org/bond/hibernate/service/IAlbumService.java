package org.bond.hibernate.service;

import java.util.List;

import org.bond.entity.AlbumEntity;
import org.bond.entity.UserEntity;

public interface IAlbumService {
	public AlbumEntity getObject(long id);

	public void save(AlbumEntity bean);

	public void save(List<AlbumEntity> list);

	public void save(AlbumEntity... list);

	public void update(AlbumEntity bean);

	public void update(UserEntity user, AlbumEntity album);

	public void delete(AlbumEntity bean);

	public void delete(String id);

	public void delete(String[] ids);
}
