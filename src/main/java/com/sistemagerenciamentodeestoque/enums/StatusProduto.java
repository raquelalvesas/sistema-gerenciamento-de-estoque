package com.sistemagerenciamentodeestoque.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum StatusProduto {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    public final String statusProduto;
    @JsonCreator
    private StatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }
}
