package br.com.desafio01.controllers;

import br.com.desafio01.domains.Cliente;
import br.com.desafio01.domains.Locacao;
import br.com.desafio01.dtos.LocacaoDTO;
import br.com.desafio01.services.ClienteService;
import br.com.desafio01.services.LocacaoService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("locacao")
public class LocacaoController {

    private final LocacaoService service;

    private final ClienteService serviceCli;

    @GetMapping
    public ResponseEntity<List<LocacaoDTO>> retornarLocacao(){
        return ResponseEntity.ok(service.retornarLocacao());
    }

    @PostMapping
    public ResponseEntity<Void> fazerLocacao(@RequestBody Locacao locacao) {
        log.info("Alugando seu livro {}", new Gson().toJson(locacao));
        serviceCli.findByNome(locacao.getCliente().getNome());
        service.fazerLocacao(locacao);
        return ResponseEntity.ok().build();
    }



}
