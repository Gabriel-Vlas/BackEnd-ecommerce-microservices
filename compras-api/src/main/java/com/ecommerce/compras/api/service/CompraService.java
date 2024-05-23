package com.ecommerce.compras.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.compra.client.dto.ClienteDTO;
import com.ecommerce.compra.client.dto.CompraDTO;
import com.ecommerce.compras.api.model.Compra;

@Service
public class CompraService {
    
    //Endpoint para cadastrar uma compra (comunicação de compras api -> usuarios api e ->produtos api)
    public ResponseEntity<CompraDTO> cadastrarCompra(Compra compra){
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.getEmail();

        return null;
    }

}
