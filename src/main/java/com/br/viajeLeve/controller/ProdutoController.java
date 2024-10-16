package com.br.viajeLeve.controller;

import com.br.viajeLeve.model.salvarProduto.request.ProdutoRequest;
import com.br.viajeLeve.model.salvarProduto.response.ProdutoResponse;
import com.br.viajeLeve.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        produtoService.cadastrarProduto(produtoRequest);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/buscar-produtos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos() {
        List<ProdutoResponse> produtos = produtoService.listarProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

}
