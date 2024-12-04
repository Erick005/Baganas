package com.br.viajeLeve.infra.controller.produto;

import com.br.viajeLeve.application.usecases.produto.AtualizarProduto;
import com.br.viajeLeve.application.usecases.produto.CadastrarProduto;
import com.br.viajeLeve.application.usecases.produto.ListarProdutoPorNome;
import com.br.viajeLeve.domain.produto.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final CadastrarProduto cadastrarProduto;
    private final AtualizarProduto atualizarProduto;
    private final ListarProdutoPorNome listarProdutoPorNome;

    public ProdutoController(CadastrarProduto cadastrarProduto, AtualizarProduto atualizarProduto, ListarProdutoPorNome listarProdutoPorNome) {
        this.cadastrarProduto = cadastrarProduto;
        this.atualizarProduto = atualizarProduto;
        this.listarProdutoPorNome = listarProdutoPorNome;
    }

    @PostMapping("/cadastrar/{id}")
    public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable Integer id) {

        Produto cadastrar = cadastrarProduto.cadastrarProduto(new Produto(produtoDTO.nome(), produtoDTO.descricao(), produtoDTO.preco(),
                produtoDTO.quantidadeEstoque(), produtoDTO.categoriaNome(), produtoDTO.categoriaId()), id);

        return new ProdutoDTO(cadastrar.getNome(), cadastrar.getDescricao(), cadastrar.getPreco(), cadastrar.getQuantidadeEstoque(),
                cadastrar.getCategoriaNome(), cadastrar.getCategoriaId());
    }

    @PutMapping("/atualizar/{id}")
    public ProdutoDTO atualizarProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable Integer id) {

        Produto atualizar = atualizarProduto.atualizarProduto(new Produto(produtoDTO.nome(), produtoDTO.descricao(), produtoDTO.preco(),
                 produtoDTO.quantidadeEstoque(), produtoDTO.categoriaNome(), produtoDTO.categoriaId()), id);

        return new ProdutoDTO(atualizar.getNome(), atualizar.getDescricao(), atualizar.getPreco(), atualizar.getQuantidadeEstoque(),
                atualizar.getCategoriaNome(), atualizar.getCategoriaId());
    }

    @GetMapping("/buscar-produtos")
    public List<ProdutoDTO> listarTodos(@RequestParam("nome") String nome) {
        List<Produto> listarProduto = listarProdutoPorNome.listarProdutoPorNome(nome);

        return listarProduto.stream()
                .map(p -> new ProdutoDTO(p.getNome(), p.getDescricao(), p.getPreco(), p.getQuantidadeEstoque(), p.getCategoriaNome(), p.getCategoriaId()))
                .collect(Collectors.toList());
    }

}
