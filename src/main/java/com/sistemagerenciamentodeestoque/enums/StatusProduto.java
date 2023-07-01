package com.sistemagerenciamentodeestoque.enums;

public enum StatusProduto {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    public final String statusProduto;

    private StatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }
}
