package com.br.viajeLeve.application.gateways;

import com.br.viajeLeve.domain.produto.Produto;

import java.util.List;

public interface RepositoryDeProduto {

    Produto cadastrarProduto(Produto produto);

    List<Produto> listarProdutoPorNome(String nome);

    Produto atualizarProduto(Produto produto, Integer id);
}
