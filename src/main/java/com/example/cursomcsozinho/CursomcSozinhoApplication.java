package com.example.cursomcsozinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomcsozinho.services.S3Service;

@SpringBootApplication
public class CursomcSozinhoApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcSozinhoApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\Livia\\Desktop\\AWS\\ana.jpg");
	
	}

	
}
