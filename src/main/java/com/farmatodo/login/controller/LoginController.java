package com.farmatodo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.login.dto.ClientDto;
import com.farmatodo.login.dto.LoginDto;
import com.farmatodo.login.exception.ServiceException;
import com.farmatodo.login.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<ClientDto> login(@RequestBody LoginDto loginDto) throws ServiceException{
		return new ResponseEntity<ClientDto>(loginService.login(loginDto),HttpStatus.OK);
	}
}
