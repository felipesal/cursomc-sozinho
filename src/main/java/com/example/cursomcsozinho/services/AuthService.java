package com.example.cursomcsozinho.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cursomcsozinho.domain.Cliente;
import com.example.cursomcsozinho.repositories.ClienteRepository;
import com.example.cursomcsozinho.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	private Random rand = new Random();

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	public void sendNewPassword(String email) {
		Cliente cliente =  clienteRepository.findByEmail(email);
		
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
			
		}
		
		String newPass = newPassword();
		cliente.setSenha(bCryptPasswordEncoder.encode(newPass));
		
		clienteRepository.save(cliente);
		
		emailService.sendNewPasswordEmail(cliente, newPass);
		
		
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i<10 ; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		
		if(opt == 0) { //gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		if(opt == 1) { // gera uma letra maiúscula
			return (char) (rand.nextInt(26) + 65);
		}
		else {//gera uma letra minúscula
			return (char)(rand.nextInt(26) + 96);
		}
		
	}
	
}
