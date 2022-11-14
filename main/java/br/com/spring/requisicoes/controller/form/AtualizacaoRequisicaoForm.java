package br.com.spring.requisicoes.controller.form;

import br.com.spring.requisicoes.modelo.Requisicao;
import br.com.spring.requisicoes.repository.RequisicaoRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class AtualizacaoRequisicaoForm {


    @NotNull @NotEmpty @Length(min = 50)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Requisicao atualizar(Long id, RequisicaoRepository requisicaoRepository) {

        Requisicao requisicao = requisicaoRepository.getReferenceById(id);
        requisicao.setNome(this.nome);

        return requisicao;
    }
}
