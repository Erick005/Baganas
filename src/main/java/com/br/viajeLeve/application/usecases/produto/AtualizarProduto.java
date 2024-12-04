package com.br.viajeLeve.application.usecases.produto;

import com.br.viajeLeve.application.gateways.RepositoryDeProduto;
import com.br.viajeLeve.domain.produto.Produto;

public class AtualizarProduto {

    private final RepositoryDeProduto repositoryDeProduto;

    public AtualizarProduto(RepositoryDeProduto repositoryDeProduto) {
        this.repositoryDeProduto = repositoryDeProduto;
    }

    public Produto atualizarProduto(Produto produto, Integer id) {
        return repositoryDeProduto.atualizarProduto(produto, id);
    }
}
