package com.br.viajeLeve.application.usecases.categoria;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;

public class DeletarCategoria {

    private final RepositoryDeCategoria repository;

    public DeletarCategoria(RepositoryDeCategoria repository) {
        this.repository = repository;
    }

    public void deletarCategoria(Integer id) {
        repository.deletarCategoria(id);
    }
}
