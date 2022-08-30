package br.com.desafio01.converters;

import br.com.desafio01.domains.Autor;
import br.com.desafio01.dtos.AutorDTO;
import org.springframework.stereotype.Component;

@Component
public class AutorConverter {

    public AutorDTO entityToDTO(Autor entity){
        AutorDTO dto = new AutorDTO();
        dto.setNome(entity.getNome());
        dto.setLivros(entity.getLivros());

        return dto;
    }

    public Autor dtoToEntity(AutorDTO dto){
        Autor entity = new Autor();
        entity.setNome(dto.getNome());
        entity.setLivros(dto.getLivros());

        return entity;
    }
}
