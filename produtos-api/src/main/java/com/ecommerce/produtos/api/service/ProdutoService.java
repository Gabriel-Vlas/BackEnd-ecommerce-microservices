package com.ecommerce.produtos.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.compra.client.dto.ProdutoDTO;
import com.ecommerce.produtos.api.model.Produto;
import com.ecommerce.produtos.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    public ProdutoDTO salvarProduto(Produto produto){
        return produtoRepository.save(produto).converterParaDTO();
    }

	public List<ProdutoDTO> obterListaProdutos() {
		return produtoRepository.findAll()
            .stream()
            .map(p -> p.converterParaDTO())
            .collect(Collectors.toList());
	}

    @Autowired
    private ProdutoRepository produtoRepository;

}
