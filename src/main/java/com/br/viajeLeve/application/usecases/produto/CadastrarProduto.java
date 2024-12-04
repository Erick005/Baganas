package com.br.viajeLeve.application.usecases.produto;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.application.gateways.RepositoryDeProduto;
import com.br.viajeLeve.domain.produto.Produto;

public class CadastrarProduto {

    private final RepositoryDeProduto repositoryDeProduto;
    private final RepositoryDeCategoria repositoryDeCategoria;

    public CadastrarProduto(RepositoryDeProduto repositoryDeProduto, RepositoryDeCategoria repositoryDeCategoria) {
        this.repositoryDeProduto = repositoryDeProduto;
        this.repositoryDeCategoria = repositoryDeCategoria;
    }

    public Produto cadastrarProduto(Produto produto, Integer id) {
        var categoria = repositoryDeCategoria.listarCategoriaId(id);
        produto.setCategoriaNome(categoria.getCategoria());
        produto.setCategoriaId(categoria.getId());
        return repositoryDeProduto.cadastrarProduto(produto);
    }
}
