package com.examples.alura.gerenciador_pedidos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedidos {
    @Id
    private long id;
    private LocalDate data;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pedidos_produtos",
            joinColumns = @JoinColumn(name = "pedidos_id"),
            inverseJoinColumns = @JoinColumn(name = "produtos_id")
    )
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto (Produto produto) {
        produtos.add(produto);
    }

    public Pedidos() {

    }

    public Pedidos(long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setProdutos(List<Produto> produto1) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
