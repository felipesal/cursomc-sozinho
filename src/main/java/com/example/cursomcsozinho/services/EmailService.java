package com.example.cursomcsozinho.services;

import org.springframework.mail.SimpleMailMessage;

import com.example.cursomcsozinho.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
