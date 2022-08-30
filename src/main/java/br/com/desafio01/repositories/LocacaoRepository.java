package br.com.desafio01.repositories;


import br.com.desafio01.domains.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {


}
