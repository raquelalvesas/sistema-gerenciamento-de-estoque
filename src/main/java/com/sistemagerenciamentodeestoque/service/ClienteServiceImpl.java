package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.dto.ClienteDTO;
import com.sistemagerenciamentodeestoque.entity.Cliente;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.repository.ClienteRepository;
import com.sistemagerenciamentodeestoque.util.UtilCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> buscarTodos() {
        List<Cliente> listaClientes = clienteRepository.findAll();

        List<ClienteDTO> clienteDTOList = new ArrayList<>();
        if (listaClientes.size() > 0) {
            for (Cliente cliente : listaClientes) {
                clienteDTOList.add(UtilCliente.converteCliente(cliente));
            }
        }
        return clienteDTOList;
    }

    @Override
    public ClienteDTO inserir(Cliente cliente) throws InfoException {
        if (UtilCliente.validarCliente(cliente)) {
            clienteRepository.save(cliente);
            return UtilCliente.converteCliente(cliente);
        } else {
            throw new InfoException("Ocorreu um erro ao cadastrar cliente", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ClienteDTO alterar(Long id, Cliente cliente) throws InfoException {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente clienteBuilder = Cliente.builder()
                    .id(id)
                    .nome(cliente.getNome() != null ? cliente.getNome() : null)
                    .statusUltimaCompra(cliente.getStatusUltimaCompra() != null ? cliente.getStatusUltimaCompra() : null)
                    .build();

            if (UtilCliente.validarCliente(clienteBuilder)) {
                clienteRepository.save(clienteBuilder);
            }
            return UtilCliente.converteCliente(cliente);
        } else {
            throw new InfoException("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public void excluir(Long id) throws InfoException {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
        } else {
            throw new InfoException("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public Cliente encontrarClientePorId(Long id) throws InfoException {
        Optional<Cliente> pessoa = clienteRepository.findById(id);

        if (pessoa.isPresent()) {
            return pessoa.get();
        } else {
            throw new InfoException("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
