package com.ecommerce.compra.client.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {
    
    private Long id;
    private ClienteDTO cliente;
    private List<ItemDTO> itens;
    private double total;
    private LocalDate data;

}
