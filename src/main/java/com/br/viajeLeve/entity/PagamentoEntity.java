package com.br.viajeLeve.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;

@Entity
@Data
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private DecimalFormat valor;
    private String metodo_pagamento;
    private String status_pagamento;
    private Timestamp data_pagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido_Entity_id;
}
