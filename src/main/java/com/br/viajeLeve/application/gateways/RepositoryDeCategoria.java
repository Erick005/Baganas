package com.br.viajeLeve.application.gateways;

import com.br.viajeLeve.domain.categoria.Categoria;

import java.util.List;

public interface RepositoryDeCategoria {

    Categoria cadastrarCategoria(Categoria categoria);

    void deletarCategoria(Integer id);

    List<Categoria> listarCategoria();

    Categoria atualizarCategoria(Integer id, Categoria categoria);

    Categoria listarCategoriaId(Integer id);
}
