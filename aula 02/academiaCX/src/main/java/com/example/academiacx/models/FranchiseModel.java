package com.example.academiacx.models;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_franchise ")
public class FranchiseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String filmes;

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

    public String getFilmes() {
        return filmes;
    }

    public void setFilmes(String filmes) {
        this.filmes = filmes;
    }
}
