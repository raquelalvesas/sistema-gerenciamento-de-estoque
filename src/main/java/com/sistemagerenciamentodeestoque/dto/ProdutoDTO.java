package com.sistemagerenciamentodeestoque.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String descricao;
    private Long codigoBarra;
    private Long lote;
    private Long quantidadeEstoque;
    private Double valorUnitario;
    private Date dataVencimento;
    private String statusProduto;
}
