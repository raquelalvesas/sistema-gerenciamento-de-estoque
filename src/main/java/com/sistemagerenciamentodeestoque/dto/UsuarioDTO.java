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
    private String endereco;
    private String cep;
    private String cidade;
    private String estado;
    private List<PermissaoUsuario> permissaoUsuarios;
    private String email;
    private String senha;
    private String codigoRecuperacaoSenha;
    private Date dataEnvioCodigo;

}
