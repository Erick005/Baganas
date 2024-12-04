package com.br.viajeLeve.infra.persistence.produto;

import com.br.viajeLeve.infra.persistence.categoria.CategoriaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "produto_entity")
public class ProdutoEntity {

    @Id // Identificador da PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente pelo banco
    private BigInteger id;

    @Column(length = 255)
    private String nome;

    @Lob
    private String descricao;

    private Double preco;
    private Integer quantidadeEstoque;

    @ManyToOne // Relacionamento de Muitos para Um. CE
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoriaId;

    public ProdutoEntity(){}

    public ProdutoEntity(String nome, String descricao, Double preco, Integer quantidadeEstoque, CategoriaEntity categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoriaId = categoriaId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public CategoriaEntity getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaEntity categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
