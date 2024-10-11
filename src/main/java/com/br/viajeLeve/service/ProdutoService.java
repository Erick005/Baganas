package com.br.viajeLeve.service;

import com.br.viajeLeve.entity.ProdutoEntity;
import com.br.viajeLeve.model.salvarProduto.request.ProdutoRequest;
import com.br.viajeLeve.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvarProduto(ProdutoRequest produtoRequest) {
        ProdutoEntity produtoEntity = ProdutoEntity.builder()
                .nome(produtoRequest.getNome())
                .descricao(produtoRequest.getDescricao())
                .preco(produtoRequest.getPreco())
                .quantidade_estoque(produtoRequest.getQuantidadeEstoque())
                .build();

        produtoRepository.save(produtoEntity);
    }
}
