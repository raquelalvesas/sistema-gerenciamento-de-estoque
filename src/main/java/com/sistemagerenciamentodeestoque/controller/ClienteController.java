package com.sistemagerenciamentodeestoque.controller;

import com.sistemagerenciamentodeestoque.dto.ClienteDTO;
import com.sistemagerenciamentodeestoque.entity.Cliente;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Tag(name = "Cliente", description = "API de Cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/buscar")
    @Operation(summary = "Buscar Clientes", description = "Busca todos os Clientes cadastrados")
    public List<ClienteDTO> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar Cliente", description = "Cadastra um Cliente")
    public ClienteDTO inserir(@RequestBody Cliente cliente) throws InfoException {
        return clienteService.inserir(cliente);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar Cliente", description = "Altera um cliente em específico")
    public ClienteDTO alterar(@PathVariable("id") Long id, @RequestBody Cliente cliente) throws InfoException {
        return clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Cliente", description = "Exclui um Cliente em específico")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
