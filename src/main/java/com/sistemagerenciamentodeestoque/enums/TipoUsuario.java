package com.sistemagerenciamentodeestoque.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUsuario {
    FUNCIONARIO("Funcionario"),
    ADMINISTRADOR("Administrador");

    private final String tipoUsuario;

    @JsonCreator
    private TipoUsuario fromValue(String text) {
        for (TipoUsuario b : TipoUsuario.values()) {
            if (String.valueOf(b.tipoUsuario).equals(text.toUpperCase())) {
                return b;
            }
        }
        return null;
    }
}
