package com.br.viajeLeve.infra.gateways.produto;

import com.br.viajeLeve.application.gateways.RepositoryDeProduto;
import com.br.viajeLeve.domain.produto.Produto;
import com.br.viajeLeve.infra.persistence.produto.ProdutoEntity;
import com.br.viajeLeve.infra.persistence.produto.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryProdutoJpa implements RepositoryDeProduto {

    private final ProdutoEntityMapper mapper;
    private final ProdutoRepository repository;

    public RepositoryProdutoJpa(ProdutoEntityMapper mapper, ProdutoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Produto cadastrarProduto(Produto produto) {
        ProdutoEntity produtoEntity = mapper.toEntity(produto);
        repository.save(produtoEntity);
        return mapper.toDomain(produtoEntity);
    }

    @Override
    public List<Produto> listarProdutoPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(p -> new Produto(p.getNome(), p.getDescricao(), p.getPreco(), p.getQuantidadeEstoque(), p.getCategoriaId().getCategoria(), p.getCategoriaId().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Produto atualizarProduto(Produto produto, Integer id) {
        BigInteger bigIntegerId = BigInteger.valueOf(id);
        ProdutoEntity produtoExistente = repository.findById(bigIntegerId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));

        produtoExistente.setId(bigIntegerId);
        ProdutoEntity produtoAtualizado = mapper.toEntity(produto);
        ProdutoEntity produtoSalvo = repository.save(produtoAtualizado);
        return mapper.toDomain(produtoSalvo);
    }
}
