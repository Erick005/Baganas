package com.br.viajeLeve.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private Timestamp data_pedido;

    @Column(length = 50)
    private String status;

    private DecimalFormat total;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario_id;

    public String getTotalFormatado() {
        DecimalFormat df = new DecimalFormat("#.##0,00");
        return df.format(total);
    }
}
