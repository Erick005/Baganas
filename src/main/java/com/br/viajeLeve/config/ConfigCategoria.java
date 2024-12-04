package com.br.viajeLeve.config;

import com.br.viajeLeve.application.gateways.RepositoryDeCategoria;
import com.br.viajeLeve.application.usecases.categoria.*;
import com.br.viajeLeve.infra.gateways.categoria.CategoriaEntityMapper;
import com.br.viajeLeve.infra.gateways.categoria.RepositoryCategoriaJpa;
import com.br.viajeLeve.infra.persistence.categoria.CategoriaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCategoria {

    @Bean
    CadastrarCategoria cadastrarCategoria(RepositoryDeCategoria repositoryDeCategoria) {
        return new CadastrarCategoria(repositoryDeCategoria);
    }

    @Bean
    DeletarCategoria deletarCategoria(RepositoryDeCategoria repositoryDeCategoria) {
        return new DeletarCategoria(repositoryDeCategoria);
    }

    @Bean
    ListarCategoria listarCategoria(RepositoryDeCategoria repositoryDeCategoria) {
        return new ListarCategoria(repositoryDeCategoria);
    }

    @Bean
    AtualizarCategoria atualizarCategoria(RepositoryDeCategoria repositoryDeCategoria) {
        return new AtualizarCategoria(repositoryDeCategoria);
    }

    @Bean
    ListarCategoriaPorId listarCategoriaPorId(RepositoryDeCategoria repositoryDeCategoria) {
        return new ListarCategoriaPorId(repositoryDeCategoria);
    }

    @Bean
    CategoriaEntityMapper categoriaEntityMapper() {
        return new CategoriaEntityMapper();
    }

    @Bean
    RepositoryCategoriaJpa repositorioDeCategoria(CategoriaEntityMapper categoriaEntity, CategoriaRepository repository) {
        return new RepositoryCategoriaJpa(categoriaEntity, repository);
    }
}
