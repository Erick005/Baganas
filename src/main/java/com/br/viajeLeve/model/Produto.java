package com.br.viajeLeve.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.text.DecimalFormat;

@Entity
@Data
public class Produto {

    @Id // Identificador da PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente pelo banco
    private BigInteger id;

    @Column(length = 255)
    private String nome;

    @Lob
    private String descricao;

    private DecimalFormat preco;
    private Integer quantidade_estoque;

    @ManyToOne // Relacionamento de Muitos para Um. CE
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria_id;

    public String getPrecoFormatado() {
        DecimalFormat df = new DecimalFormat("#.##0,00");
        return df.format(preco);
    }
}
