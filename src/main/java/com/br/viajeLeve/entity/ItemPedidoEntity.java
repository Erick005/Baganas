package com.br.viajeLeve.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.text.DecimalFormat;

@Entity
@Data
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private Integer quantidade;
    private DecimalFormat preco_unitario;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produto_Entity_id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido_Entity_id;

    public String getPrecoUnitarioFormatado() {
        DecimalFormat df = new DecimalFormat("#.##0,00");
        return df.format(preco_unitario);
    }
}
