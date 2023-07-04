package com.sistemagerenciamentodeestoque.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itens_venda")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ItensVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_interno")
    private Long idInterno;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Venda venda;
    @ManyToOne
    private Produto produto;
}
