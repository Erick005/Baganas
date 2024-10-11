package com.br.viajeLeve.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.text.DecimalFormat;

@Entity
@Data
public class Item_pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private Integer quantidade;
    private DecimalFormat preco_unitario;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto_id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido_id;

    public String getPrecoUnitarioFormatado() {
        DecimalFormat df = new DecimalFormat("#.##0,00");
        return df.format(preco_unitario);
    }
}
