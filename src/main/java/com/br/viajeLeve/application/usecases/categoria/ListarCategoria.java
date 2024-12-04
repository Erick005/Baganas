package com.br.viajeLeve.application.usecases.categoria;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.domain.categoria.Categoria;

import java.util.List;

public class ListarCategoria {

    private final RepositoryDeCategoria repository;

    public ListarCategoria(RepositoryDeCategoria repository) {
        this.repository = repository;
    }

    public List<Categoria> listarCategoria() {
        return repository.listarCategoria();
    }
}
