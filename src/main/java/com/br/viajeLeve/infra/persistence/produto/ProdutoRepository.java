package com.br.viajeLeve.infra.persistence.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigInteger> {

    List<ProdutoEntity> findByNomeContainingIgnoreCase(String nome);
}
