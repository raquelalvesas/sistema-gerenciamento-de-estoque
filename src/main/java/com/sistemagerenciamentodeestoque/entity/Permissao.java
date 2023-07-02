package com.sistemagerenciamentodeestoque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permissao")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Permissao extends Auditavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

}
