package br.com.desafio01.converters;

import br.com.desafio01.domains.Cliente;
import br.com.desafio01.dtos.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {

    public ClienteDTO entityToDTO (Cliente entity){
        ClienteDTO dto = new ClienteDTO();
        dto.setAtivo(entity.getAtivo());

        return dto;
    }

    public Cliente dtoToEntity (ClienteDTO dto){
        Cliente entity = new Cliente();
        entity.setAtivo(dto.getAtivo());
        return entity;
    }
}
