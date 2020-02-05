package com.example.cursomcsozinho.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.cursomcsozinho.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	@Transactional
	List<Cidade> findByEstadoIdOrderByNomeAsc(Integer estadoId);
	
}
