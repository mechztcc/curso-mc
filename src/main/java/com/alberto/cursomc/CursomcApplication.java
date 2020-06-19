package com.alberto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alberto.cursomc.domain.Categoria;
import com.alberto.cursomc.domain.Cidade;
import com.alberto.cursomc.domain.Cliente;
import com.alberto.cursomc.domain.Endereco;
import com.alberto.cursomc.domain.Estado;
import com.alberto.cursomc.domain.Produto;
import com.alberto.cursomc.domain.enums.TipoCliente;
import com.alberto.cursomc.repositories.CategoriaRepository;
import com.alberto.cursomc.repositories.CidadeRepository;
import com.alberto.cursomc.repositories.ClienteRepository;
import com.alberto.cursomc.repositories.EnderecoRepository;
import com.alberto.cursomc.repositories.EstadoRepository;
import com.alberto.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
			
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
		Estado est1 = new Estado(null ,"Minas Gerais");
		Estado est2 = new Estado(null ,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email.com", "12345678909",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("35441212", "35451212"));
		
		Endereco e1 = new Endereco(null, "Rua flores","300","Apt 30", "Jardim","53900000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800","Centro", "53900000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}

}
