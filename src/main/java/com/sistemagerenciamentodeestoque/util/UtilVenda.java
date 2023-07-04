package com.sistemagerenciamentodeestoque.util;

import com.sistemagerenciamentodeestoque.dto.VendaDTO;
import com.sistemagerenciamentodeestoque.entity.Venda;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilVenda {
    public static Boolean validarVenda(Venda venda) throws InfoException {
        if (venda.getUsuario() == null) {
            throw new InfoException("MESSAGE.USUARIO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (venda.getCliente() == null) {
            throw new InfoException("MESSAGE.CLIENTE_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (venda.getItensVenda() == null || venda.getItensVenda().size() == 0) {
            throw new InfoException("MESSAGE.ITEM_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static VendaDTO converteVenda(Venda venda) {
        return VendaDTO.builder()
                .id(venda.getId())
                .itensVenda(UtilItensVenda.converterListaItensVenda(venda.getItensVenda()))
                .build();
    }
}
