package com.examples.alura.gerenciador_pedidos;

import com.examples.alura.gerenciador_pedidos.repositorio.CategoriaRepository;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {
    @Id
    private long id;
    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public Categoria(){
    }

    public Categoria(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
