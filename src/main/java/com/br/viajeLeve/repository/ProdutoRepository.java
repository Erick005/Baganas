package com.br.viajeLeve.repository;

import com.br.viajeLeve.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProdutoRepository extends JpaRepository<Produto, BigInteger> {



}
