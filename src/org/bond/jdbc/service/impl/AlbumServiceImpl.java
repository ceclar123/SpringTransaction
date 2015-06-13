package org.bond.jdbc.service.impl;

import org.bond.jdbc.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements IAlbumService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int update(String sSql) {
		return jdbcTemplate.update(sSql);
	}

}
