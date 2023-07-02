package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.UsernameNotFoundException;
import com.sistemagerenciamentodeestoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalheService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario;
    }
}