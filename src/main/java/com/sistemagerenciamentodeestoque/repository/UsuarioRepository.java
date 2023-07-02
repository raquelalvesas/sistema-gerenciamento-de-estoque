package com.sistemagerenciamentodeestoque.repository;

import com.sistemagerenciamentodeestoque.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Usuario findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);
}
