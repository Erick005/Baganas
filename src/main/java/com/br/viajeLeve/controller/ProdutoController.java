package com.br.viajeLeve.controller;

import com.br.viajeLeve.model.salvarProduto.request.ProdutoRequest;
import com.br.viajeLeve.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/salvar")
    public ResponseEntity salvarProduto(@RequestBody ProdutoRequest produtoRequest) {
        produtoService.salvarProduto(produtoRequest);
        return ResponseEntity.status(202).build();
    }

    @GetMapping
    public List<ProdutoRequest> listarproduto(){
        List<ProdutoRequest> produtos = new ArrayList<>();
        produtos.add(new ProdutoRequest("Mala 01", "Mala de avião", 500.00, 2, "Mala de mão" ));
        return produtos;
    }

}
