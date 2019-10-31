package com.example.cursomcsozinho.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomcsozinho.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<>();
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categorias.addAll(Arrays.asList(cat1, cat2));		
		return categorias;
	}
}
