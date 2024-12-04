package com.br.viajeLeve.infra.controller.categoria;

import com.br.viajeLeve.application.usecases.categoria.*;
import com.br.viajeLeve.domain.categoria.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CadastrarCategoria cadastrarCategoria;
    private final DeletarCategoria deletarCategoria;
    private final ListarCategoria listarCategoria;
    private final AtualizarCategoria atualizarCategoria;
    private final ListarCategoriaPorId listarCategoriaPorId;

    public CategoriaController(CadastrarCategoria categoria, DeletarCategoria deletarCategoria, ListarCategoria listarCategoria,
                               AtualizarCategoria atualizarCategoria, ListarCategoriaPorId listarCategoriaPorId) {
        this.cadastrarCategoria = categoria;
        this.deletarCategoria = deletarCategoria;
        this.listarCategoria = listarCategoria;
        this.atualizarCategoria = atualizarCategoria;
        this.listarCategoriaPorId = listarCategoriaPorId;
    }

    @PostMapping("/cadastrar")
    public CategoriaDTO cadastrarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria salvarCategoria = cadastrarCategoria.cadastrarCategoria(new Categoria(categoriaDTO.id(), categoriaDTO.categoria()));
        return new CategoriaDTO(salvarCategoria.getId(), salvarCategoria.getCategoria());
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCategoria(@PathVariable Integer id) {
        deletarCategoria.deletarCategoria(id);
    }

    @GetMapping("listar-categorias")
    public List<CategoriaDTO> listarCategoria() {
        return listarCategoria.listarCategoria().stream()
                .map(c -> new CategoriaDTO(c.getId(), c.getCategoria()))
                .collect(Collectors.toList());
    }

    @PutMapping("/atualizar/{id}")
    public CategoriaDTO atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = atualizarCategoria.atualizarCategoria(id, new Categoria(categoriaDTO.id(), categoriaDTO.categoria()));
        return new CategoriaDTO(categoria.getId(), categoria.getCategoria());
    }

    @GetMapping("/{id}")
    public CategoriaDTO listarCategoriaPorId(@PathVariable Integer id) {
        Categoria categoria = listarCategoriaPorId.listarCategoriaPorId(id);
        return new CategoriaDTO(categoria.getId(), categoria.getCategoria());
    }
}
