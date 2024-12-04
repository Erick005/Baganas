package com.br.viajeLeve.infra.controller.produto;

public record ProdutoDTO(String nome, String descricao, Double preco, Integer quantidadeEstoque, String categoriaNome, Integer categoriaId) {
}
