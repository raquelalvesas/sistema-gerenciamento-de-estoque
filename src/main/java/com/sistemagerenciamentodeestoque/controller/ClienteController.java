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
@Tag(name = "Cliente", description = "API de Cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/buscar")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Buscar Clientes", description = "Busca todos os Clientes cadastrados")
    public List<ClienteDTO> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Cadastrar Cliente", description = "Cadastra um Cliente")
    public ClienteDTO inserir(@RequestBody Cliente cliente) throws InfoException {
        return clienteService.inserir(cliente);
    }

    @PutMapping("/atualizar/{id}")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Atualizar Cliente", description = "Altera um cliente em específico")
    public ClienteDTO alterar(@PathVariable("id") Long id, @RequestBody Cliente cliente) throws InfoException {
        return clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/deletar/{id}")
    @CrossOrigin("http://localhost:3000")
    @Operation(summary = "Deletar Cliente", description = "Exclui um Cliente em específico")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
