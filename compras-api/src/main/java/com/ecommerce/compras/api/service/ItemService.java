package com.ecommerce.compras.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.compra.client.dto.ItemDTO;
import com.ecommerce.compra.client.dto.ProdutoDTO;
import com.ecommerce.compras.api.model.Item;
import com.ecommerce.compras.api.repository.ItemRepository;

@Service
public class ItemService {
    
    public ProdutoDTO obterDetalhesDoProduto(String codigo){
        RestTemplate template = new RestTemplate();
        
        String url = String.format("%s/produtos/cod?cod=%s", produtoWsUrl,codigo);

        ResponseEntity<ProdutoDTO> response = template.getForEntity(url, ProdutoDTO.class);

        return response.getBody();
    }

    public ItemDTO salvarItem(Item item, ProdutoDTO produto){
        return itemRepository.save(item).converterParaDTO(produto);
    }

    @Value(value = "${produto.ws.url}")
    private String produtoWsUrl;

    @Autowired
    private ItemRepository itemRepository;
}
