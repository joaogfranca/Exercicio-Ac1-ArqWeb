package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false)
    private Integer Qtd;

    @ManyToOne
    @JoinColumn(name = "categoriaProdutos_id")
    private Categoria categoriaProdutos;

    public Produto(Long id, String nome, Integer qtd, Categoria categoriaProdutos) {
        this.id = id;
        this.nome = nome;
        Qtd = qtd;
        this.categoriaProdutos = categoriaProdutos;
    }

    public Produto() {
    }

    public Produto(Long id, String nome, Integer qtd) {
        this.id = id;
        this.nome = nome;
        Qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return Qtd;
    }

    public void setQtd(Integer qtd) {
        Qtd = qtd;
    }

    public Categoria getCategoriaProduto() {
        return categoriaProdutos;
    }

    public void setCategoriaProduto(Categoria categoriaProduto) {
        this.categoriaProdutos = categoriaProduto;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + Qtd + "]";
    }
}
