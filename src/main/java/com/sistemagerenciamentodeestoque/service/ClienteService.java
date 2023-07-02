package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.ClienteDTO;
import com.sistemagerenciamentodeestoque.entity.Cliente;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> buscarTodos();
    ClienteDTO inserir(Cliente cliente) throws InfoException;
    ClienteDTO alterar(Long id, Cliente cliente) throws InfoException;
    void excluir(Long id) throws InfoException;
}
