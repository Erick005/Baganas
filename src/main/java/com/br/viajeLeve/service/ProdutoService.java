package com.br.viajeLeve.service;

import com.br.viajeLeve.entity.CategoriaEntity;
import com.br.viajeLeve.entity.ProdutoEntity;
import com.br.viajeLeve.model.salvarProduto.request.ProdutoRequest;
import com.br.viajeLeve.repository.CategoriaRepository;
import com.br.viajeLeve.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void cadastrarProduto(ProdutoRequest produtoRequest) {
        CategoriaEntity categoria= categoriaRepository.findById(produtoRequest.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com Id: " + produtoRequest.getCategoriaId()));

        ProdutoEntity produtoEntity = ProdutoEntity.builder()
                .nome(produtoRequest.getNome())
                .descricao(produtoRequest.getDescricao())
                .preco(produtoRequest.getPreco())
                .quantidade_estoque(produtoRequest.getQuantidadeEstoque())
                .categoria_id(categoria)
                .build();

        produtoRepository.save(produtoEntity);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
