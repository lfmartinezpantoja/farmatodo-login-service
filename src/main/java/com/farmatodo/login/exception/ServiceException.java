package com.farmatodo.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceException extends Exception {

	private final String message;
	private final Integer httpStatus;
	private static final long serialVersionUID = 5612364608294885104L;
	public String getMessage() {
		return message;
	}
	public Integer getHttpStatus() {
		return httpStatus;
	}
	public ServiceException(Integer httpStatus,String message) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public ServiceException( Integer httpStatus,Enum<?> message) {
		super();
		this.message = message.name();
		this.httpStatus = httpStatus;
	}
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	
	
}
