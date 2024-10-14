package com.br.viajeLeve.repository;

import com.br.viajeLeve.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, BigInteger> {

}
