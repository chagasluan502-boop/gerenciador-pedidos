package com.examples.alura.gerenciador_pedidos.repositorio;

import com.examples.alura.gerenciador_pedidos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
