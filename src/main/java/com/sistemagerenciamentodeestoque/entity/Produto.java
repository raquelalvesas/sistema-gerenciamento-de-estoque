package com.sistemagerenciamentodeestoque.entity;

import com.sistemagerenciamentodeestoque.enums.StatusProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5, max = 100, message = "Deve conter entre 5 e 15 caracteres")
    @NotBlank(message = "Não porde conter valor em branco")
    @Column(name = "descricao")
    private String descricao;
    @NotBlank(message = "Não porde conter valor em branco")
    @Column(name = "codigo_barra")
    private Long codigoBarra;
    @NotBlank(message = "Não porde conter valor em branco")
    @Column(name = "lote")
    private Long lote;
    @Column(name = "quantidade_estoque")
    private Long quantidadeEstoque;
    @Digits(integer = 10, fraction = 2)
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento")
    private Date dataVencimento;
    @Column(name = "status")
    private String statusProduto;
}