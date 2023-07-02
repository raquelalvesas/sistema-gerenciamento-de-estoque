package com.sistemagerenciamentodeestoque.controller;

import com.sistemagerenciamentodeestoque.entity.Produto;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@RequiredArgsConstructor
@Tag(name = "Produto", description = "API de Produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/buscar")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Buscar Produtos", description = "Busca todos os Produtos cadastrados")
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Cadastrar Produto", description = "Cadastra um Produto")
    public Produto inserir(@RequestBody Produto produto) throws InfoException {
        return produtoService.inserir(produto);
    }

    @PutMapping("/atualizar/{id}")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Alterar Produto", description = "Altera um Produto em específico")
    public Produto alterar(@PathVariable("id") Long id, @RequestBody Produto produto) throws InfoException {
        return produtoService.alterar(id, produto);
    }
    @DeleteMapping("/deletar/{id}")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Deletar Produto", description = "Deleta um Produto em específico")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
