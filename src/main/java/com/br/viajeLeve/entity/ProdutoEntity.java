package com.br.viajeLeve.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {

    @Id // Identificador da PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente pelo banco
    private BigInteger id;

    @Column(length = 255)
    private String nome;

    @Lob
    private String descricao;

    private Double preco;
    private Integer quantidade_estoque;

    @ManyToOne // Relacionamento de Muitos para Um. CE
    @JoinColumn(name = "categoria_nome")
    private CategoriaEntity categoria_nome;

//    public String getPrecoFormatado() {
//        DecimalFormat df = new DecimalFormat("#.##0,00");
//        return df.format(preco);
//    }
}
