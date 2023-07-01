package com.sistemagerenciamentodeestoque.service;

import com.sistemagerenciamentodeestoque.entity.Produto;
import com.sistemagerenciamentodeestoque.exceptions.InfoException;
import com.sistemagerenciamentodeestoque.repository.ProdutoRepository;
import com.sistemagerenciamentodeestoque.util.UtilProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto produto) throws InfoException {
        if (UtilProduto.validarProduto(produto)) {
            return produtoRepository.save(produto);
        } else {
            throw new InfoException("Ocorreu um erro ao cadastrar produto", HttpStatus.BAD_REQUEST);
        }
    }

    public Produto alterar(Long id, Produto produto) throws InfoException {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            Produto produtoBuilder = Produto.builder()
                    .id(id)
                    .descricao(produto.getDescricao() != null ? produto.getDescricao() : null)
                    .valorUnitario(produto.getValorUnitario() != null ? produto.getValorUnitario() : null)
                    .pesoUnitario(produto.getPesoUnitario() != null ? produto.getPesoUnitario() : null)
                    .quantidadeEstoque(produto.getQuantidadeEstoque() != null ? produto.getQuantidadeEstoque() : null)
                    .status(produto.getStatus() != null ? produto.getStatus() : null)
                    .dataVencimento(produto.getDataVencimento() != null ? produto.getDataVencimento() : null)
                    .build();

            if (UtilProduto.validarProduto(produtoBuilder)) {
                produtoRepository.save(produtoBuilder);
            }
            return produtoBuilder;
        } else {
            throw new InfoException("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public void deletar(Long id) throws InfoException {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
        } else {
            throw new InfoException("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}