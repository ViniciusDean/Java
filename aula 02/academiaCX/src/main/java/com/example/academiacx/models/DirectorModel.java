package com.example.academiacx.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_director")
public class DirectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String filmes_trabalhados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmes_trabalhados() {
        return filmes_trabalhados;
    }

    public void setFilmes_trabalhados(String filmes_trabalhados) {
        this.filmes_trabalhados = filmes_trabalhados;
    }
}
