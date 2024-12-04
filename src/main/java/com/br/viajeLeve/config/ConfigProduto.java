package com.br.viajeLeve.config;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.application.gateways.RepositoryDeProduto;
import com.br.viajeLeve.application.usecases.produto.AtualizarProduto;
import com.br.viajeLeve.application.usecases.produto.CadastrarProduto;
import com.br.viajeLeve.application.usecases.produto.ListarProdutoPorNome;
import com.br.viajeLeve.infra.controller.produto.ProdutoController;
import com.br.viajeLeve.infra.gateways.produto.ProdutoEntityMapper;
import com.br.viajeLeve.infra.gateways.produto.RepositoryProdutoJpa;
import com.br.viajeLeve.infra.persistence.produto.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProduto {

    @Bean
    CadastrarProduto cadastrarProduto(RepositoryDeProduto repositoryDeProduto, RepositoryDeCategoria repositoryDeCategoria) {
        return new CadastrarProduto(repositoryDeProduto, repositoryDeCategoria);
    }

    @Bean
    AtualizarProduto atualizarProduto(RepositoryDeProduto repositoryDeProduto) {
        return new AtualizarProduto(repositoryDeProduto);
    }

    @Bean
    ListarProdutoPorNome listarProdutoPorNome(RepositoryDeProduto repositoryDeProduto) {
        return new ListarProdutoPorNome(repositoryDeProduto);
    }

    @Bean
    ProdutoEntityMapper produtoEntityMapper() {
        return new ProdutoEntityMapper();
    }

    @Bean
    RepositoryProdutoJpa repositoryDeProduto(ProdutoEntityMapper produtoEntityMapper, ProdutoRepository repositoryDeProduto) {
        return new RepositoryProdutoJpa(produtoEntityMapper, repositoryDeProduto);
    }
}
