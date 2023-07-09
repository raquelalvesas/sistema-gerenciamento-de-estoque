package com.sistemagerenciamentodeestoque.util;

import com.sistemagerenciamentodeestoque.dto.ProdutoDTO;
import com.sistemagerenciamentodeestoque.entity.Produto;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilProduto {
    public static Boolean validarProduto(Produto produto) throws InfoException {
        if (produto.getCodigoBarra() == null || produto.getCodigoBarra().equals("")) {
            throw new InfoException("MESSAGE.CODIGO_BARRA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getLote() == null || produto.getLote().equals("")) {
            throw new InfoException("MESSAGE.LOTE_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
            throw new InfoException("MESSAGE.DESCRICAO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getValorUnitario() == null) {
            throw new InfoException("MESSAGE.VALOR_UNITARIO_REQUIRED", HttpStatus.BAD_REQUEST);
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
                .codigoBarra(produto.getCodigoBarra())
                .lote(produto.getLote())
                .descricao(produto.getDescricao())
                .valorUnitario(produto.getValorUnitario())
                .status(produto.getStatus())
                .dataVencimento(produto.getDataVencimento())
                .build();
    }
}
