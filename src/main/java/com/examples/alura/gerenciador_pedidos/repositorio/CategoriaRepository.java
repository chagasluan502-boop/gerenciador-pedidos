package com.examples.alura.gerenciador_pedidos.repositorio;

import com.examples.alura.gerenciador_pedidos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
