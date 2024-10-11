package com.br.viajeLeve.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "cpf"})} // não vai deixar o banco de dados inserir informações duplicadas.
)
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(length = 255)
    private String nome;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String senha;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Lob
    private String endereco;

    @Column(length = 20)
    private String role;
}
