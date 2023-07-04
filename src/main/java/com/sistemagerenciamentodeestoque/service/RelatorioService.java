package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.RetornoRelatorioDTO;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;

import java.text.ParseException;

public interface RelatorioService {
    RetornoRelatorioDTO vendasPorUsuario(Long id) throws InfoException;
    RetornoRelatorioDTO vendasFiltroPorData(String dataInicio, String dataFim) throws InfoException, ParseException;
    RetornoRelatorioDTO comprasPorCliente(Long id) throws InfoException;
}
