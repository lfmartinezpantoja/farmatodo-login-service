package com.farmatodo.login.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmatodo.login.model.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {


	public Optional<Client> findByIdentificationNumber(String identificationNumber);

	public List<Client> findByEmailOrUsername(String email, String username);
	
	public Optional<Client> findByUsername(String username);
}
