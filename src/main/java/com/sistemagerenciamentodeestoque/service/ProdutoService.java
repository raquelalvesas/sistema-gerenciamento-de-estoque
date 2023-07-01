package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.entity.Produto;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscarTodos();

    Produto inserir(Produto objeto) throws InfoException;

    Produto alterar(Long id, Produto objeto) throws InfoException;

    void deletar(Long id) throws InfoException;
}
