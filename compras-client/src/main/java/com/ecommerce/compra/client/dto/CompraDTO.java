package com.ecommerce.compra.client.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {
    
    private ClienteDTO clienteDTO;
    private List<ItemDTO> itemDTO;
    private double total;
    private LocalDate data;

}
