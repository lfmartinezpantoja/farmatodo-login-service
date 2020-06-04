package com.farmatodo.login.service.imp;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farmatodo.login.dto.ClientDto;
import com.farmatodo.login.dto.LoginDto;
import com.farmatodo.login.exception.ServiceException;
import com.farmatodo.login.model.Client;
import com.farmatodo.login.repository.ClientRepository;
import com.farmatodo.login.service.LoginService;

import lombok.extern.java.Log;

import static com.farmatodo.login.error.Error.PASSWORD_INCORRECT;
import static com.farmatodo.login.error.Error.USERNAME_DOESNT_EXIST;

@Log
@Service
public class LoginServiceImp implements LoginService {

	
	@Value("${login.post}")
	String loginMessage;
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	ClientRepository clientRepository;

	@Override
	public ClientDto login(LoginDto loginDto) throws ServiceException {
		Optional<Client> clientCheck = clientRepository.findByUsername(loginDto.getUsername());
		if (!clientCheck.isPresent()) {
			throw new ServiceException(HttpStatus.NOT_FOUND.value(), USERNAME_DOESNT_EXIST);
		}
		boolean passwordCheck = passwordEncoder.matches(loginDto.getPassword(), clientCheck.get().getPassword());
		if (!passwordCheck) {
			throw new ServiceException(HttpStatus.BAD_REQUEST.value(), PASSWORD_INCORRECT);
		}
		ClientDto clientDto = new ClientDto();
		modelMapper.map(clientCheck.get(), clientDto);
		LocalTime time = LocalTime.now(ZoneId.of("America/Bogota"));
		clientDto.setPassword(null);
		log.info(String.format(loginMessage, clientDto.getUsername(),time.toString()));
		return clientDto;
	}

}
