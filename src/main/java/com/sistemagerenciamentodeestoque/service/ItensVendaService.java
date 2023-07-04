package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.entity.ItensVenda;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

public interface ItensVendaService {
    ItensVenda inserirItensVenda(ItensVenda itensVenda);
    void excluirItensVenda(Long id) throws InfoException;
}
