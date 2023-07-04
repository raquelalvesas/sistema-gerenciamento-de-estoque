package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.VendaDTO;
import com.sistemagerenciamentodeestoque.entity.Venda;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.util.List;

public interface VendaService {
    List<VendaDTO> buscarTodos();

    VendaDTO inserir(Venda venda) throws InfoException;

    void excluir(Long id) throws InfoException;
}
