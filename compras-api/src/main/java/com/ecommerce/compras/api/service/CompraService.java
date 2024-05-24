package com.ecommerce.compras.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.compra.client.dto.ClienteDTO;
import com.ecommerce.compra.client.dto.CompraDTO;
import com.ecommerce.compra.client.dto.ItemDTO;
import com.ecommerce.compras.api.model.Compra;
import com.ecommerce.compras.api.repository.CompraRepository;

@Service
public class CompraService {
    
    public ClienteDTO obterDetalhesCompra(String email){
        RestTemplate template = new RestTemplate();

        String url = String.format("%s/clientes/email?email=%s", usuarioWsUrl,email);

        ResponseEntity<ClienteDTO> response = template.getForEntity(url, ClienteDTO.class);

        return response.getBody();
    }

    public CompraDTO salvCompra(Compra compra, ClienteDTO cliente, List<ItemDTO> itens){
        return compraRepository.save(compra).converterCompraDTO(cliente, itens);
    }

    @Value(value = "${usuario.ws.url}")
    private String usuarioWsUrl;

    @Autowired
    private CompraRepository compraRepository;

}
