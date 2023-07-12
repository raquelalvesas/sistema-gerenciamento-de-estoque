package com.sistemagerenciamentodeestoque.controller;

import com.sistemagerenciamentodeestoque.dto.VendaDTO;
import com.sistemagerenciamentodeestoque.entity.Venda;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/venda")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Tag(name = "Venda", description = "API de Venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;
    @GetMapping("/buscar")
    @Operation(summary = "Buscar Vendas", description = "Busca todas as Vendas cadastradas")
    public List<VendaDTO> buscarTodos() {
        return vendaService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar Venda", description = "Cadastra uma Venda")
    public VendaDTO inserir(@RequestBody Venda venda) throws InfoException {
        return vendaService.inserir(venda);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Venda", description = "Exclui uma Venda em específico")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        vendaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
