package com.farmatodo.login.service;

import com.farmatodo.login.dto.ClientDto;
import com.farmatodo.login.dto.LoginDto;
import com.farmatodo.login.exception.ServiceException;

public interface LoginService {

	
	public ClientDto login(LoginDto loginDto) throws ServiceException;
}
