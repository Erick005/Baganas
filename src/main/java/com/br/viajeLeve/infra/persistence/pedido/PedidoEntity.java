package com.br.viajeLeve.infra.persistence.pedido;

import com.br.viajeLeve.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;

@Entity
@Data
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private Timestamp data_pedido;

    @Column(length = 50)
    private String status;

    private DecimalFormat total;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario_Entity_id;

    public String getTotalFormatado() {
        DecimalFormat df = new DecimalFormat("#.##0,00");
        return df.format(total);
    }
}
