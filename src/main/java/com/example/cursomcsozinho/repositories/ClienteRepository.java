package com.example.cursomcsozinho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursomcsozinho.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
