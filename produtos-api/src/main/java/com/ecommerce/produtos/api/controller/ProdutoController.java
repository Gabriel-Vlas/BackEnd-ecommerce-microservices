package com.ecommerce.produtos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.produtos.api.dto.ProdutoDTO;
import com.ecommerce.produtos.api.model.Produto;
import com.ecommerce.produtos.api.service.ProdutoService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody Produto produto) {        
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.obterListaProdutos());
    }    
    
    
}
