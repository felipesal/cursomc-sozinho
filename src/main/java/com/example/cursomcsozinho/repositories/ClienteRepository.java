package com.example.cursomcsozinho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cursomcsozinho.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Transactional
	Cliente findByEmail(String email);
	
}
