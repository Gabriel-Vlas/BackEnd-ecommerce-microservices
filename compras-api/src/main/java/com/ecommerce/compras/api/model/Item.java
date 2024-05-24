package com.ecommerce.compras.api.model;

import com.ecommerce.compra.client.dto.ItemDTO;
import com.ecommerce.compra.client.dto.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigoProduto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double preco;

    // Converter DTO Item
    public ItemDTO converterParaDTO(ProdutoDTO produto){
        ItemDTO dto = new ItemDTO();

        dto.setId(id);
        dto.setProduto(produto);
        dto.setQuantidade(quantidade);
        dto.setSubTotal(preco * quantidade);

        return dto;
    }

}
