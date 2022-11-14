package br.com.spring.requisicoes.repository;

import br.com.spring.requisicoes.modelo.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {


    List<Requisicao> findByLocaisNome(String nomeLocais);
}
