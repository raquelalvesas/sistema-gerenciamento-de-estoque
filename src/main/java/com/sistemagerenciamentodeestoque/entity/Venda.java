package com.sistemagerenciamentodeestoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venda")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_interno")
    private Long idInterno;
    @Column(name = "data_venda")
    private Date dataVenda = new Date();
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Cliente cliente;
    @Transient
    private List<ItensVenda> itensVenda;
}
