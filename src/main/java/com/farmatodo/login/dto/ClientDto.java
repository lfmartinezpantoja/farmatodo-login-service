package com.farmatodo.login.dto;



import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
	
	private Long clientId;
	@NotNull
	private String identificationNumber;
	@NotNull
	private String firstName;
	private String secondName;
	@NotNull
	private String lastName;
	private String surName;
	@NotNull
	private String age;
	@NotNull
	private String email;
	@NotNull
	private String username;
	@NotNull
	private String password;
}
