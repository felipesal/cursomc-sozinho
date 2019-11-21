package com.example.cursomcsozinho.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomcsozinho.domain.Pedido;
import com.example.cursomcsozinho.repositories.PedidoRepository;
import com.example.cursomcsozinho.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException (
		"Objeto não encontrado. Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}