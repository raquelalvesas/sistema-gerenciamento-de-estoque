package com.sistemagerenciamentodeestoque.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public enum StatusProduto {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    @Column(name = "status_produto")
    @Enumerated(EnumType.STRING)
    public final String statusProduto;
    @JsonCreator
    private StatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }
}
