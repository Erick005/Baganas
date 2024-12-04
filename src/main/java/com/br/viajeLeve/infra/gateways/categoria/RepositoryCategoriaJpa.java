package com.br.viajeLeve.infra.gateways.categoria;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.domain.categoria.Categoria;
import com.br.viajeLeve.infra.persistence.categoria.CategoriaEntity;
import com.br.viajeLeve.infra.persistence.categoria.CategoriaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryCategoriaJpa implements RepositoryDeCategoria {

    private final CategoriaEntityMapper mapper;
    private final CategoriaRepository repository;

    public RepositoryCategoriaJpa(CategoriaEntityMapper categoriaEntity, CategoriaRepository repository) {
        this.mapper = categoriaEntity;
        this.repository = repository;
    }

    @Override
    public Categoria cadastrarCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = mapper.toEntity(categoria);
        repository.save(categoriaEntity);
        return mapper.toDomain(categoriaEntity);
    }

    @Override
    public void deletarCategoria(Integer id) {
        CategoriaEntity categoriaEntity = repository.findById(id);
        repository.deleteById(BigInteger.valueOf(categoriaEntity.getId()));
    }

    @Override
    public List<Categoria> listarCategoria() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Categoria atualizarCategoria(Integer id, Categoria categoria) {
        CategoriaEntity categoriaEntity = repository.findById(id);
        if (!categoriaEntity.equals(null)) {
            var atualizar = mapper.toEntity(categoria);
            categoriaEntity.setCategoria(categoria.getCategoria());
            repository.save(categoriaEntity);
            return mapper.toDomain(atualizar);
        }
        return null;
    }

    @Override
    public Categoria listarCategoriaId(Integer id) {
        CategoriaEntity categoriaEntity = repository.findById(id);
        return mapper.toDomain(categoriaEntity);
    }
}
