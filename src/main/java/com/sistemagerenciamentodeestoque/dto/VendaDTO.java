package com.sistemagerenciamentodeestoque.dto;

import com.sistemagerenciamentodeestoque.entity.Cliente;
import com.sistemagerenciamentodeestoque.entity.ItensVenda;
import com.sistemagerenciamentodeestoque.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendaDTO {
    private Long id;
    private UsuarioDTO usuario;
    private ClienteDTO cliente;
    private List<ItensVendaDTO> itensVenda;
}
