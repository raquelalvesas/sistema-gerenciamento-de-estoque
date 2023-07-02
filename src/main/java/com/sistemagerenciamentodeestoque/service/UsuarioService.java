package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.UsuarioDTO;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> buscarTodos();

    UsuarioDTO inserir(Usuario usuario) throws InfoException;

    Usuario alterar(Long id, Usuario usuario) throws InfoException;

    void excluir(Long id) throws InfoException;
}