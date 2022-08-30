package br.com.desafio01.repositories;

import br.com.desafio01.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    Optional<Cliente> findByNome (String nome);

    @Query("SELECT p FROM Cliente p WHERE p.id = :id")
    Optional<Cliente> findById (Long id);
}
