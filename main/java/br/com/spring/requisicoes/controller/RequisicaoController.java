package br.com.spring.requisicoes.controller;

import br.com.spring.requisicoes.controller.dto.DetalhesDaRequisicaoDto;
import br.com.spring.requisicoes.controller.dto.RequisicaoDto;
import br.com.spring.requisicoes.controller.form.AtualizacaoRequisicaoForm;
import br.com.spring.requisicoes.controller.form.RequisicaoForm;
import br.com.spring.requisicoes.modelo.Requisicao;
import br.com.spring.requisicoes.repository.LocaisRepository;
import br.com.spring.requisicoes.repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class RequisicaoController {

    @Autowired
    private RequisicaoRepository requisicaoRepository;
    @Autowired
    private LocaisRepository locaisRepository;


   @GetMapping
    public List<RequisicaoDto> lista(String nomeLocais) {
        if (nomeLocais == null) {
           List<Requisicao> requisicoes = requisicaoRepository.findAll();
           return RequisicaoDto.converter(requisicoes);
        } else {
           List<Requisicao> requisicoes = requisicaoRepository.findByLocaisNome(nomeLocais);
           return RequisicaoDto.converter(requisicoes);
       }

    }


    @PostMapping
    @Transactional
    public ResponseEntity<RequisicaoDto> cadastrar(@RequestBody @Validated RequisicaoForm form, UriComponentsBuilder uriBuilder) {
        Requisicao requisicao = form.converter(locaisRepository);
        requisicaoRepository.save(requisicao);

        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(requisicao.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequisicaoDto(requisicao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDaRequisicaoDto> detalhar(@PathVariable Long id) {
        Optional<Requisicao> topico = requisicaoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDaRequisicaoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RequisicaoDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoRequisicaoForm form) {
        Optional<Requisicao> optional = requisicaoRepository.findById(id);
        if (optional.isPresent()) {
            Requisicao requisicao = form.atualizar(id, requisicaoRepository);
            return ResponseEntity.ok(new RequisicaoDto(requisicao));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Requisicao> optional = requisicaoRepository.findById(id);
        if (optional.isPresent()) {
            requisicaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
