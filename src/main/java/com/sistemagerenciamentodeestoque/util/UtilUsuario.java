package com.sistemagerenciamentodeestoque.util;

import com.sistemagerenciamentodeestoque.dto.UsuarioDTO;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilUsuario {
    public static Boolean validarUsuario(Usuario usuario) throws InfoException {
        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getDataNascimento() == null || usuario.getDataNascimento().equals("")) {
            throw new InfoException("MESSAGE.DATA_NASCIMENTO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
            throw new InfoException("MESSAGE.EMAIL_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")) {
            throw new InfoException("MESSAGE.SENHA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEndereco() == null || usuario.getEndereco().equals("")) {
            throw new InfoException("MESSAGE.ENDERECO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEstado() == null || usuario.getEstado().equals("")) {
            throw new InfoException("MESSAGE.ESTADO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getCep() == null || usuario.getCep().equals("")) {
            throw new InfoException("MESSAGE.CEP_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
            throw new InfoException("MESSAGE.EMAIL_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static UsuarioDTO converteUsuario(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .codigoRecuperacaoSenha(usuario.getCodigoRecuperacaoSenha())
                .endereco(usuario.getEndereco())
                .cidade(usuario.getCidade())
                .estado(usuario.getEstado())
                .cep(usuario.getCep())
                .permissaoUsuarios(usuario.getPermissaoUsuarios())
                .build();
    }
}
