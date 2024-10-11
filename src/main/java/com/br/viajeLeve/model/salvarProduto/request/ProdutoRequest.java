package com.br.viajeLeve.model.salvarProduto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoRequest {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("preco")
    private Double preco;

    @JsonProperty("quantidadeEstoque")
    private Integer quantidadeEstoque;

    @JsonProperty("categoriaNome")
    private String categoriaNome;

    public ProdutoRequest(String nome, String descricao, Double preco, Integer quantidadeEstoque, String categoriaNome) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoriaNome = categoriaNome;
    }

    public ProdutoRequest() {}

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
