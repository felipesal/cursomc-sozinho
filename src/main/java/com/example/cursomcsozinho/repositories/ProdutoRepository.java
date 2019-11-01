package com.example.cursomcsozinho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursomcsozinho.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
