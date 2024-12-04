package com.br.viajeLeve.application.usecases.categoria;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.domain.categoria.Categoria;

public class CadastrarCategoria {

    private final RepositoryDeCategoria repository;

    public CadastrarCategoria(RepositoryDeCategoria repositoryDeCategoria){
        this.repository = repositoryDeCategoria;
    }

    public Categoria cadastrarCategoria(Categoria categoria) {
        return repository.cadastrarCategoria(categoria);
    }
}
