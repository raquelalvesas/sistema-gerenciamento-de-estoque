package com.sistemagerenciamentodeestoque.entity;

import com.sistemagerenciamentodeestoque.enums.StatusProduto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produto")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Produto extends Auditavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo_barra")
    private Long codigoBarra;
    @Column(name = "lote")
    private Long lote;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Column(name = "quantidade_estoque")
    private Long quantidadeEstoque;
    @Column(name = "status")
    private String status;
    @Column(name = "data_vencimento")
    private Date dataVencimento;
}