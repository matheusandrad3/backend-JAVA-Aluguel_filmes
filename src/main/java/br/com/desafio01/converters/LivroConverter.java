package br.com.desafio01.converters;

import br.com.desafio01.domains.Livro;
import br.com.desafio01.dtos.LivroDTO;
import org.springframework.stereotype.Component;

@Component
public class LivroConverter {

    public LivroDTO entityToDTO (Livro entity) {
        LivroDTO dto = new LivroDTO();
        dto.setId(entity.getId());

        return dto;
    }

    public Livro dtoToEntity(LivroDTO dto){
        Livro entity = new Livro();
        entity.setId(dto.getId());

        return entity;
    }
}
