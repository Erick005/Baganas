package com.br.viajeLeve.application.usecases.categoria;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.domain.categoria.Categoria;

public class AtualizarCategoria {

    private final RepositoryDeCategoria repository;

    public AtualizarCategoria(RepositoryDeCategoria repository) {
        this.repository = repository;
    }

    public Categoria atualizarCategoria(Integer id, Categoria categoria) {
        return repository.atualizarCategoria(id, categoria);
    }
}
