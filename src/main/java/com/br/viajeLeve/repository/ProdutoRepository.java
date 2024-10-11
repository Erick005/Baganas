package com.br.viajeLeve.repository;

import com.br.viajeLeve.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigInteger> {

    @Override
    ProdutoEntity save(ProdutoEntity produtoEntity);

}
