package com.ecommerce.produtos.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.compra.client.dto.ProdutoDTO;
import com.ecommerce.produtos.api.model.Produto;
import com.ecommerce.produtos.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    public ProdutoDTO salvarProduto(Produto produto){
        return produtoRepository.save(produto).converterParaDTO();
    }

	public Page<ProdutoDTO> obterListaProdutos(Pageable pageable) {
		return produtoRepository.findAll(pageable).map(Produto::converterParaDTO);
	}

    public ProdutoDTO obterProutoPeloCodigo(String codigo){
        Optional<Produto> produto = produtoRepository.findByCodigo(codigo);

        if (produto.isPresent()) {
            return produto.get().converterParaDTO();
        }
        return null;
    }

    @Autowired
    private ProdutoRepository produtoRepository;

}
