package com.br.viajeLeve.application.usecases.produto;

import com.br.viajeLeve.application.gateways.RepositoryDeProduto;
import com.br.viajeLeve.domain.produto.Produto;
import com.br.viajeLeve.infra.controller.produto.ProdutoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ListarProdutoPorNome {

    private final RepositoryDeProduto repositoryDeProduto;

    public ListarProdutoPorNome(RepositoryDeProduto repositoryDeProduto) {
        this.repositoryDeProduto = repositoryDeProduto;
    }

    public List<Produto> listarProdutoPorNome(String nome) {
        return repositoryDeProduto.listarProdutoPorNome(nome);

//        return listaProduto;

//                .stream()
//                .map(lp -> new Produto(lp.getNome(), lp.getDescricao(), lp.getPreco(), lp.getQuantidadeEstoque(), lp.getCategoriaNome(), lp.getCategoriaId()))
//                .collect(Collectors.toList());
    }
}
