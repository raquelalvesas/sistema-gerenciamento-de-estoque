package com.sistemagerenciamentodeestoque.dto;

import com.sistemagerenciamentodeestoque.entity.Auditavel;
import com.sistemagerenciamentodeestoque.entity.PermissaoUsuario;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO extends Auditavel {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String email;
    private String senha;
    private String codigoRecuperacaoSenha;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private List<PermissaoUsuario> permissaoUsuarios;
    private Date dataEnvioCodigo;
}
