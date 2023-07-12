package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.UsuarioDTO;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.repository.UsuarioRepository;
import com.sistemagerenciamentodeestoque.util.UtilUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO login(String email, String senha) throws InfoException {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new InfoException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        if (!usuario.getSenha().equals(senha)) {
            throw new InfoException("Senha incorreta", HttpStatus.UNAUTHORIZED);
        }

        return UtilUsuario.converteUsuario(usuario);
    }
}
