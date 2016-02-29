package com.dataup.dc.web.base.security.service;

import com.dataup.dc.web.base.security.entity.LoginDTO;


public interface SecurityService {

	public boolean login(LoginDTO loginDTO) throws Exception;

	public void logout() throws Exception;

}
