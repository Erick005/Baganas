package com.br.viajeLeve.service;

import com.br.viajeLeve.entity.CategoriaEntity;
import com.br.viajeLeve.model.salvarProduto.request.CategoriaRequest;
import com.br.viajeLeve.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void cadastrarCategoria(CategoriaRequest categoriaRequest) {
        CategoriaEntity categoriaEntity = CategoriaEntity.builder()
                .nome(categoriaRequest.getNome())
                .build();
        categoriaRepository.save(categoriaEntity);
    }
}
