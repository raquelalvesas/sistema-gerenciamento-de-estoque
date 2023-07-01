package com.sistemagerenciamentodeestoque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
    private Long id;
    private String descricao;
    private Double valorUnitario;
    private String pesoUnitario;
    private Long quantidadeEstoque;
    private String status;
    private Date dataVencimento;
}
