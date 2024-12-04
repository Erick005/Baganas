package com.br.viajeLeve.infra.persistence.categoria;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_entity")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String categoria;

    public CategoriaEntity(){}

    public CategoriaEntity(String categoria) {
        this.categoria = categoria;
    }

    public CategoriaEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
