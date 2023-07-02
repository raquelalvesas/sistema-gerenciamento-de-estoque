package com.sistemagerenciamentodeestoque.util;

import com.sistemagerenciamentodeestoque.dto.ClienteDTO;
import com.sistemagerenciamentodeestoque.entity.Cliente;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilCliente {

    public static Boolean validarCliente(Cliente cliente) throws InfoException {
        if (cliente.getNome() == null || cliente.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (cliente.getStatusUltimaCompra() == null || cliente.getStatusUltimaCompra().equals("")) {
            throw new InfoException("MESSAGE.STATUS_ULTIMA_COMPRA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static ClienteDTO converteCliente(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .build();
    }
}
