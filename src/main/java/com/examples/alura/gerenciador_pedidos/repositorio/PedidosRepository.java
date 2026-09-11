package com.examples.alura.gerenciador_pedidos.repositorio;

import com.examples.alura.gerenciador_pedidos.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
