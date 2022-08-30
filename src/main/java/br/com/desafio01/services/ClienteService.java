package br.com.desafio01.services;

import antlr.StringUtils;
import br.com.desafio01.converters.ClienteConverter;
import br.com.desafio01.domains.Cliente;
import br.com.desafio01.dtos.ClienteDTO;
import br.com.desafio01.excepetions.CadastroLocacaoException;
import br.com.desafio01.excepetions.ExcluirClienteException;
import br.com.desafio01.repositories.ClienteRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteConverter converter;

    public List<ClienteDTO> retornarTodosClientes(){
        return repository.findAll()
                .stream()
                .map(converter::entityToDTO)
                .collect(Collectors.toList());
    }

    public Cliente cadastrarCliente(Cliente cliente) {
                 return repository.save(cliente);

    }

    public void findByNome (String nome) {

        repository.findByNome(nome)
                .ifPresent(dispositivo ->{
                    log.info("Você já tem um livro locado em seu nome {}", new Gson().toJson(nome));
                    throw new CadastroLocacaoException("Você ja tem um livro locado, favor devolver para locar outro");
                });

        repository.findByNome(nome);
    }

    public void deletarCliente (Long id){

        repository.findById(id)
                        .ifPresentOrElse(cliente -> {
                            cliente.getAtivo()
                                    .equals(false);
                            repository.deleteById(id);
                        },() ->{
                            throw new ExcluirClienteException("erro.cliente.esta-ativo");
                        });

    }

}
