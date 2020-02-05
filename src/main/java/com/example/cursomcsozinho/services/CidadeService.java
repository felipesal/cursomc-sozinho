package com.example.cursomcsozinho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomcsozinho.domain.Cidade;
import com.example.cursomcsozinho.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findByEstado(Integer estadoId){
		return repo.findByEstadoIdOrderByNomeAsc(estadoId);
	}
	
}
