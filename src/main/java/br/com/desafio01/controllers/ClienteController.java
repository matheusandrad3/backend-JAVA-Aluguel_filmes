package br.com.desafio01.controllers;


import br.com.desafio01.converters.ClienteConverter;
import br.com.desafio01.domains.Cliente;
import br.com.desafio01.dtos.ClienteDTO;
import br.com.desafio01.excepetions.ExcluirClienteException;
import br.com.desafio01.repositories.ClienteRepository;
import br.com.desafio01.services.ClienteService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService service;
    private final ClienteRepository repository;
    private final ClienteConverter converter;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> retornarTodosClientes(){
        return ResponseEntity.ok(service.retornarTodosClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = converter.dtoToEntity(clienteDTO);
        Cliente clienteSalvo = service.cadastrarCliente(cliente);
        converter.entityToDTO(clienteSalvo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.ok().build();
    }
}
