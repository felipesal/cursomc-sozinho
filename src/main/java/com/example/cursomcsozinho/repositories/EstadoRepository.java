package com.example.cursomcsozinho.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cursomcsozinho.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	@Transactional
	public List<Estado> findAllByOrderByNome();
	
}
