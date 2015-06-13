package org.bond.hibernate.service;

import org.bond.exception.NoRollbackException;

public interface IUserAlbumService {
	void setNameDesc(String newName, String newDesc);
}
