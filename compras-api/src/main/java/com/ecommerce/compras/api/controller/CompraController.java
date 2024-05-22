package com.ecommerce.compras.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.compra.client.dto.CompraDTO;
import com.ecommerce.compras.api.model.Compra;

@RestController
@RequestMapping(value = "/compras")
public class CompraController {

    @PostMapping
    public ResponseEntity<CompraDTO> cadastrarCompra(@RequestBody Compra compra){
        return null;
    }
    
}
