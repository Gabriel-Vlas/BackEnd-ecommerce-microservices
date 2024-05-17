package com.ecommerce.produtos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.produtos.api.dto.ProdutoDTO;
import com.ecommerce.produtos.api.model.Produto;
import com.ecommerce.produtos.api.repository.ProdutoRepository;
import com.ecommerce.produtos.api.service.ProdutoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody Produto produto) {        
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoService.salvarProduto(produto));
    }
    
    
}
