package com.sistemagerenciamentodeestoque.repository;

import com.sistemagerenciamentodeestoque.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
