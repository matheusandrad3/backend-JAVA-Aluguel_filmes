package br.com.desafio01.repositories;

import br.com.desafio01.domains.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
