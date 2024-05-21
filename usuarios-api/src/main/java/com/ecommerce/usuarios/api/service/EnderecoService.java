package com.ecommerce.usuarios.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.usuarios.api.dto.EnderecoDTO;

@Service
public class EnderecoService {
    
    public EnderecoDTO buscarEnderecoPeloCep(String cep){
        RestTemplate restTemplate = new RestTemplate();
        
        //String url = "https://viacep.com.br/ws/"+cep+"/json/";
        String url2 = String.format("https://viacep.com.br/ws/%s/json/", cep);

        ResponseEntity<EnderecoDTO> response = restTemplate.getForEntity(url2, EnderecoDTO.class);

        return response.getBody();

    }

}
