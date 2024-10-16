package com.br.viajeLeve.repository;

import com.br.viajeLeve.entity.ProdutoEntity;
import com.br.viajeLeve.model.salvarProduto.response.ProdutoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigInteger> {
}
