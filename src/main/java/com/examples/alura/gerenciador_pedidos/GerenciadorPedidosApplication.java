package com.examples.alura.gerenciador_pedidos;

import com.examples.alura.gerenciador_pedidos.repositorio.CategoriaRepository;
import com.examples.alura.gerenciador_pedidos.repositorio.FornecedorRepository;
import com.examples.alura.gerenciador_pedidos.repositorio.PedidosRepository;
import com.examples.alura.gerenciador_pedidos.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private PedidosRepository pedidosRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(produtoRepository, pedidosRepository, categoriaRepository, fornecedorRepository);
		principal.Executar();
	}
}
