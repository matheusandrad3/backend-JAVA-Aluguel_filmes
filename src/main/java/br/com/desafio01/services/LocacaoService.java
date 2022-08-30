package br.com.desafio01.services;

import br.com.desafio01.converters.LocacaoConverter;
import br.com.desafio01.domains.Cliente;
import br.com.desafio01.domains.Livro;
import br.com.desafio01.domains.Locacao;
import br.com.desafio01.dtos.LocacaoDTO;
import br.com.desafio01.excepetions.CadastroLocacaoException;
import br.com.desafio01.repositories.ClienteRepository;
import br.com.desafio01.repositories.LocacaoRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class LocacaoService {

    @Autowired
    private final LocacaoRepository repository;

    private final ClienteService serviceCli;

    private final LocacaoConverter converter;


    public List<LocacaoDTO> retornarLocacao(){
       return repository.findAll()
               .stream()
               .map(converter::entityToDTO)
               .collect(Collectors.toList());
    }

    @Transactional
    public void fazerLocacao (Locacao locacao){


        Cliente cliente = new Cliente();
        cliente.setNome(cliente.getNome());
        cliente.setAtivo(cliente.getAtivo());


        Livro livro = new Livro();
        livro.setNome(livro.getNome());

        repository.save(locacao);
    }

}
