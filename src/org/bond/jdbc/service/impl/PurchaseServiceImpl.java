package org.bond.jdbc.service.impl;

import org.bond.jdbc.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

	@Autowired
	private AlbumServiceImpl albumService;
	@Autowired
	private UserServiceImpl userService;

	@Override
	public void purchase() {
		String sSql = "update g_user set name='¬Î≈©456' where id=1";
		userService.update(sSql);

		sSql = "update g_album1 seta a_name='œ‡≤·456',a_desc='√Ë ˆ' where id=1";
		albumService.update(sSql);

	}
}
