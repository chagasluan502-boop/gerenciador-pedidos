package com.examples.alura.gerenciador_pedidos;

import com.examples.alura.gerenciador_pedidos.repositorio.CategoriaRepository;
import com.examples.alura.gerenciador_pedidos.repositorio.FornecedorRepository;
import com.examples.alura.gerenciador_pedidos.repositorio.PedidosRepository;
import com.examples.alura.gerenciador_pedidos.repositorio.ProdutoRepository;
import org.hibernate.cfg.Compatibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.FormatterClosedException;
import java.util.List;

@Component
public class Principal {

    private final CategoriaRepository categoriaRepository;

    private final ProdutoRepository produtoRepository;

    private final PedidosRepository pedidosRepository;

    private final FornecedorRepository fornecedorRepository;

    public Principal(ProdutoRepository produtoRepository, PedidosRepository pedidosRepository, CategoriaRepository categoriaRepository, FornecedorRepository fornecedorRepository) {
        this.produtoRepository = produtoRepository;
        this.pedidosRepository = pedidosRepository;
        this.categoriaRepository = categoriaRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public void Executar() {

        Categoria categoriaEletronicos = new Categoria(1L, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(2L, "Livros");
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));

        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos, fornecedorTech);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos, fornecedorTech);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros, fornecedorLivros);
        produto1.setFornecedor(fornecedorTech);
        produto2.setFornecedor(fornecedorTech);
        produto3.setFornecedor(fornecedorLivros);
        produtoRepository.saveAll(List.of(produto1, produto2, produto3));

        System.out.println("Fornecedor produto1: " +
                produto1.getFornecedor().getNome());

        System.out.println("Fornecedor produto2: " +
                produto2.getFornecedor().getNome());

        System.out.println("Fornecedor produto3: " +
                produto3.getFornecedor().getNome());


        Pedidos pedido1 = new Pedidos(1L, LocalDate.now());
        pedido1.setProdutos(List.of(produto1, produto3));
        Pedidos pedido2 = new Pedidos(2L, LocalDate.now().minusDays(1));
        pedido2.setProdutos(List.of(produto2));
        pedidosRepository.saveAll(List.of(pedido1, pedido2));


        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        System.out.println("\nPedidos e seus produtos:");
        pedidosRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }


}

