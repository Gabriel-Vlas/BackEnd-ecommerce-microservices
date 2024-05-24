package com.ecommerce.compras.api.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.compra.client.dto.ClienteDTO;
import com.ecommerce.compra.client.dto.CompraDTO;
import com.ecommerce.compra.client.dto.ItemDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailCliente;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @OneToMany
    private List<Item> itens;

    public CompraDTO converterCompraDTO(ClienteDTO cliente, List<ItemDTO> itens){
        CompraDTO dto = new CompraDTO();

        dto.setId(id);
        dto.setCliente(cliente);
        dto.setData(data);
        dto.setTotal(total);
        dto.setItens(itens);

        return dto;
    }

}
