package com.br.viajeLeve.application.usecases.categoria;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.domain.categoria.Categoria;

public class ListarCategoriaPorId {

    private final RepositoryDeCategoria repositoryDeCategoria;

    public ListarCategoriaPorId(RepositoryDeCategoria repositoryDeCategoria) {
        this.repositoryDeCategoria = repositoryDeCategoria;
    }

    public Categoria listarCategoriaPorId(Integer id) {
        return repositoryDeCategoria.listarCategoriaId(id);
    }
}
