package br.com.desafio01.dtos;

import br.com.desafio01.domains.Locacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {

    private Long id;
    private Locacao idLocacao;
    private String nome;
}
