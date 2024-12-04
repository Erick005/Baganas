package com.br.viajeLeve.domain.categoria;

public class Categoria {

    private Integer id;
    private String categoria;

    public Categoria(Integer id, String categoria) {
        if (categoria.equals(null)) {
            throw new NullPointerException("A categoria não pode ser igual a null");
        }
        this.id = id;
        this.categoria = categoria;
    }

    public Categoria(Integer id) {
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
