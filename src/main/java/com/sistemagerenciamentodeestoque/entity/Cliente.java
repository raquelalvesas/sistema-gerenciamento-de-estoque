package com.sistemagerenciamentodeestoque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente extends Auditavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "name")
    private String nome;
    @Column(name = "status_ultima_compra")
    private String statusUltimaCompra;
    @Column(name = "cupom")
    private String Cupom;
}
