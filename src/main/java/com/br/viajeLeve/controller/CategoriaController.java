package com.br.viajeLeve.controller;

import com.br.viajeLeve.model.salvarProduto.request.CategoriaRequest;
import com.br.viajeLeve.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        categoriaService.cadastrarCategoria(categoriaRequest);
        return ResponseEntity.status(202).build();
    }
}
