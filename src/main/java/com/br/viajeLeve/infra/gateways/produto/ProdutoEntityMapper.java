package com.br.viajeLeve.infra.gateways.produto;

import com.br.viajeLeve.domain.produto.Produto;
import com.br.viajeLeve.infra.persistence.categoria.CategoriaEntity;
import com.br.viajeLeve.infra.persistence.categoria.CategoriaRepository;
import com.br.viajeLeve.infra.persistence.produto.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoEntityMapper {

    @Autowired
    private CategoriaRepository repository;

    public ProdutoEntity toEntity(Produto produto) {
        CategoriaEntity categoriaEntity = repository.findById(produto.getCategoriaId());

        return new ProdutoEntity(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidadeEstoque(), categoriaEntity);
    }

    public Produto toDomain(ProdutoEntity produto) {
        return new Produto(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidadeEstoque(), produto.getCategoriaId().getCategoria(), produto.getCategoriaId().getId());
    }
}
