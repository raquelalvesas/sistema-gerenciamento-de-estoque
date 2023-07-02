package com.sistemagerenciamentodeestoque.repository;

import com.sistemagerenciamentodeestoque.entity.PermissaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, Long> {
    List<PermissaoUsuario> findByUsuarioId(Long id);
}
