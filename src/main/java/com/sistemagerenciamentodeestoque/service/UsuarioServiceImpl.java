package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.UsuarioDTO;
import com.sistemagerenciamentodeestoque.entity.PermissaoUsuario;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.repository.PermissaoUsuarioRepository;
import com.sistemagerenciamentodeestoque.repository.UsuarioRepository;
import com.sistemagerenciamentodeestoque.util.UtilUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PermissaoUsuarioRepository permissaoUsuarioRepository;

    public List<UsuarioDTO> buscarTodos() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
        if (listaUsuarios.size() > 0) {
            for (Usuario usuario : listaUsuarios) {
                usuarioDTOList.add(UtilUsuario.converteUsuario(usuario));
            }
        }
        return usuarioDTOList;
    }

    public UsuarioDTO inserir(Usuario usuario) throws InfoException {
        if (UtilUsuario.validarUsuario(usuario)) {
            usuario.getPermissaoUsuarios().get(0).setUsuario(usuario);

            usuarioRepository.save(usuario);

            return UtilUsuario.converteUsuario(usuario);
        } else {
            throw new InfoException("Ocorreu um erro ao cadastrar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    public Usuario alterar(Long id, Usuario usuario) throws InfoException {
        Optional<Usuario> optionalPessoa = usuarioRepository.findById(id);

        if (optionalPessoa.isPresent()) {
            Usuario usuarioBuilder = Usuario.builder()
                    .id(id)
                    .nome(usuario.getNome() != null ? usuario.getNome() : null)
                    .dataNascimento(usuario.getDataNascimento() != null ? usuario.getDataNascimento() : null)
                    .email(usuario.getEmail() != null ? usuario.getEmail() : null)
                    .senha(usuario.getSenha() != null ? usuario.getSenha() : null)
                    .codigoRecuperacaoSenha(usuario.getCodigoRecuperacaoSenha() != null? usuario.getCodigoRecuperacaoSenha() : null)
                    .endereco(usuario.getEndereco() != null ? usuario.getEndereco() : null)
                    .cidade(usuario.getCidade() != null ? usuario.getCidade() : null)
                    .estado(usuario.getEstado() != null ? usuario.getEstado() : null)
                    .cep(usuario.getCep() != null ? usuario.getCep() : null)
                    .permissaoUsuarios(usuario.getPermissaoUsuarios() != null && usuario.getPermissaoUsuarios().size() > 0 ? usuario.getPermissaoUsuarios() : null)
                    .build();

            if (UtilUsuario.validarUsuario(usuarioBuilder)) {
                usuarioBuilder.getPermissaoUsuarios().get(0).setUsuario(usuarioBuilder);
                usuarioRepository.save(usuarioBuilder);
            }
            return usuarioBuilder;
        } else {
            throw new InfoException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public void excluir(Long id) throws InfoException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            List<PermissaoUsuario> permissoesUsuario = permissaoUsuarioRepository.findByUsuarioId(usuario.get().getId());

            usuarioRepository.delete(usuario.get());
            permissaoUsuarioRepository.deleteAll(permissoesUsuario);
        } else {
            throw new InfoException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public Usuario encontrarUsuarioPorId(Long id) throws InfoException {
        Optional<Usuario> pessoa = usuarioRepository.findById(id);

        if (pessoa.isPresent()) {
            return pessoa.get();
        } else {
            throw new InfoException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}