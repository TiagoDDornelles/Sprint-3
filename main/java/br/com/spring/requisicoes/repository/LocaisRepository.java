package br.com.spring.requisicoes.repository;

import br.com.spring.requisicoes.modelo.Locais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocaisRepository extends JpaRepository<Locais,Long> {
    Locais findByNome(String nome);
}
