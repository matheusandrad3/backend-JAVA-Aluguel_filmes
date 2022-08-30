package br.com.desafio01.dtos;

import br.com.desafio01.domains.Livro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocacaoDTO {


    private Long id;
    private String nome;
    private Livro livro;
}
