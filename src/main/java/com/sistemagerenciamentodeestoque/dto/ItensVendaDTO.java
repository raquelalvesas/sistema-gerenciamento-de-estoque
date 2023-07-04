package com.sistemagerenciamentodeestoque.dto;

import com.sistemagerenciamentodeestoque.entity.Produto;
import com.sistemagerenciamentodeestoque.entity.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItensVendaDTO {
    private Double quantidade;
    private Double valorUnitario;
    private VendaDTO venda;
    private ProdutoDTO produto;
}
