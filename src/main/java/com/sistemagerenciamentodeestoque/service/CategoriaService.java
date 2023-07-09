package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.entity.Categoria;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.util.List;

public interface CategoriaService {
    List<Categoria> buscarTodos();

    Categoria inserir(Categoria objeto) throws InfoException;

    Categoria alterar(Long id, Categoria objeto) throws InfoException;

    void excluir(Long id) throws InfoException;
}
