package com.examples.alura.gerenciador_pedidos.repositorio;

import com.examples.alura.gerenciador_pedidos.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
