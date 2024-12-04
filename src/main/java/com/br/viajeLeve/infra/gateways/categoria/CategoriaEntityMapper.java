package com.br.viajeLeve.infra.gateways.categoria;

import com.br.viajeLeve.domain.categoria.Categoria;
import com.br.viajeLeve.infra.persistence.categoria.CategoriaEntity;

public class CategoriaEntityMapper {

    public CategoriaEntity toEntity(Categoria categoria) {
        return new CategoriaEntity(categoria.getCategoria());
    }

    public Categoria toDomain(CategoriaEntity categoria) {
        return new Categoria(categoria.getId(), categoria.getCategoria());
    }
}
