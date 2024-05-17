package com.ecommerce.usuarios.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.usuarios.api.dto.ClienteDTO;
import com.ecommerce.usuarios.api.model.Cliente;
import com.ecommerce.usuarios.api.repository.ClienteRepository;

@Service
public class ClienteService {

    public ClienteDTO salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente).converterParaDTO();
    }

    public List<ClienteDTO> obterListaClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(c -> c.converterParaDTO())
                .collect(Collectors.toList());
    }

    public Page<ClienteDTO> obterPaginaClientes(Pageable paginacao) {
        return clienteRepository.findAll(paginacao).map(Cliente::converterParaDTO);
    }

    public ClienteDTO obterCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            return cliente.get().converterParaDTO();
        }

        return null;
    }

    public List<ClienteDTO> obterClientePeloNome(String nome){
        
        Optional<List<Cliente>> clientes = clienteRepository.findByNomeLike(nome+"%");

        if(clientes.isPresent()){
            return clienteRepository.findByNomeLike(nome+"%")
            .get()
            .stream()
            .map(c -> c.converterParaDTO())
            .collect(Collectors.toList());
        }

        return null;

    }

    @Autowired
    private ClienteRepository clienteRepository;

}
