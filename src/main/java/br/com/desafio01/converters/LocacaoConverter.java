package br.com.desafio01.converters;

import br.com.desafio01.domains.Livro;
import br.com.desafio01.domains.Locacao;
import br.com.desafio01.dtos.LocacaoDTO;
import org.springframework.stereotype.Component;

@Component
public class LocacaoConverter {

    public LocacaoDTO entityToDTO (Locacao entity){
        LocacaoDTO dto = new LocacaoDTO();
        dto.setLivro(dto.getLivro());
        dto.setId(entity.getId());

        return dto;
    }

    public Locacao dtoToEntity (LocacaoDTO dto){
        Locacao entity = new Locacao();
        entity.setId(dto.getId());

        Livro livro = new Livro();
        return entity;
    }
}
