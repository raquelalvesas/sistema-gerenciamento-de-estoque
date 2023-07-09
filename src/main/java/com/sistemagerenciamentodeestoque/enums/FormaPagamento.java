package com.sistemagerenciamentodeestoque.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
@Getter
public enum FormaPagamento {
    DINHEIRO("Dinheiro"),
    CARTAO("Cartao");

    public final String formaPagamento;

    @JsonCreator
    private FormaPagamento(String statusProduto) {
        this.formaPagamento = getFormaPagamento();
    }
}
