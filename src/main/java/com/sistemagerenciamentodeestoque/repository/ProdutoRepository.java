package com.sistemagerenciamentodeestoque.repository;

import com.sistemagerenciamentodeestoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
