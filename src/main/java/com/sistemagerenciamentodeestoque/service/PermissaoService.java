package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.entity.Permissao;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.util.List;

public interface PermissaoService {
    List<Permissao> buscarTodos();

    Permissao inserir(Permissao permissao) throws InfoException;

    Permissao alterar(Long id, Permissao permissao) throws InfoException;

    void excluir(Long id) throws InfoException;

    void vincularPessoaPermissaoCliente(Usuario usuario) throws InfoException;
}
