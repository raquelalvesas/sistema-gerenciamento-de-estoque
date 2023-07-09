package com.sistemagerenciamentodeestoque.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
    private Long id;
    private Long codigoBarra;
    private Long lote;
    private String descricao;
    private Double valorUnitario;
    private Long quantidadeEstoque;
    private String status;
    private Date dataVencimento;
}
