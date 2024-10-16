package com.br.viajeLeve.model.salvarProduto.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ProdutoResponse {

    private String nome;

    private String descricao;

    private Double preco;

    private Integer quantidadeEstoque;

    private String categoriaNome;

    private BigInteger categoriaId;

    public ProdutoResponse(String nome, String descricao, Double preco, Integer quantidadeEstoque, String categoriaNome, BigInteger categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoriaNome = categoriaNome;
        this.categoriaId = categoriaId;
    }
}
