package com.sistemagerenciamentodeestoque.util;

import com.sistemagerenciamentodeestoque.dto.ProdutoDTO;
import com.sistemagerenciamentodeestoque.entity.Produto;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilProduto {
    public static Boolean validarProduto(Produto produto) throws InfoException {
        if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
            throw new InfoException("MESSAGE.DESCRICAO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getValorUnitario() == null) {
            throw new InfoException("MESSAGE.VALOR_UNITARIO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getPesoUnitario() == null) {
            throw new InfoException("MESSAGE.PESO_UNITARIO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getQuantidadeEstoque() == null) {
            throw new InfoException("MESSAGE.QUANTIDADE_ESTOQUE_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getStatus() == null) {
            throw new InfoException("MESSAGE.STATUS_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getDataVencimento() == null) {
            throw new InfoException("MESSAGE.DATA_VENCIMENTO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    public static ProdutoDTO converterProduto(Produto produto) {
        return ProdutoDTO.builder()
                .descricao(produto.getDescricao())
                .valorUnitario(produto.getValorUnitario())
                .pesoUnitario(produto.getPesoUnitario())
                .status(produto.getStatus())
                .dataVencimento(produto.getDataVencimento())
                .build();
    }


}
