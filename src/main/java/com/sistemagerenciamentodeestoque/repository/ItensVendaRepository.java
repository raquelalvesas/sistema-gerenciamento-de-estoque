package com.sistemagerenciamentodeestoque.repository;

import com.sistemagerenciamentodeestoque.entity.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long> {
    List<ItensVenda> findItensVendasByVendaId(Long id);
}
