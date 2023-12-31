package com.sistemagerenciamentodeestoque.controller;

import com.sistemagerenciamentodeestoque.dto.UsuarioDTO;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Tag(name = "Usuário", description = "API de Usuário")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/buscar")
    @Operation(summary = "Buscar Usuários", description = "Busca todas os Usuários cadastrados")
    public List<UsuarioDTO> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar Usuário", description = "Cadastra um Usuário")
    public UsuarioDTO inserir(@RequestBody Usuario usuario) throws InfoException {
        return usuarioService.inserir(usuario);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Alterar Usuário", description = "Altera um Usuário em específico")
    public Usuario alterar(@PathVariable("id") Long id, @RequestBody Usuario usuario) throws InfoException {
        return usuarioService.alterar(id, usuario);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Usuário", description = "Exclui um Usuário em específico")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}