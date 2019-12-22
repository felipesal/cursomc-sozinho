package com.example.cursomcsozinho;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomcsozinho.domain.Categoria;
import com.example.cursomcsozinho.domain.Cidade;
import com.example.cursomcsozinho.domain.Cliente;
import com.example.cursomcsozinho.domain.Endereco;
import com.example.cursomcsozinho.domain.Estado;
import com.example.cursomcsozinho.domain.ItemPedido;
import com.example.cursomcsozinho.domain.Pagamento;
import com.example.cursomcsozinho.domain.PagamentoComBoleto;
import com.example.cursomcsozinho.domain.PagamentoComCartao;
import com.example.cursomcsozinho.domain.Pedido;
import com.example.cursomcsozinho.domain.Produto;
import com.example.cursomcsozinho.domain.enums.EstadoPagamento;
import com.example.cursomcsozinho.domain.enums.TipoCliente;
import com.example.cursomcsozinho.repositories.CategoriaRepository;
import com.example.cursomcsozinho.repositories.CidadeRepository;
import com.example.cursomcsozinho.repositories.ClienteRepository;
import com.example.cursomcsozinho.repositories.EnderecoRepository;
import com.example.cursomcsozinho.repositories.EstadoRepository;
import com.example.cursomcsozinho.repositories.ItemPedidoRepository;
import com.example.cursomcsozinho.repositories.PagamentoRepository;
import com.example.cursomcsozinho.repositories.PedidoRepository;
import com.example.cursomcsozinho.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcSozinhoApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcSozinhoApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {

			
	}

	
}
