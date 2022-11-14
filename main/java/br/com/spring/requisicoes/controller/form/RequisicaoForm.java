package br.com.spring.requisicoes.controller.form;

import br.com.spring.requisicoes.modelo.Locais;
import br.com.spring.requisicoes.modelo.RegiaoTopico;
import br.com.spring.requisicoes.modelo.Requisicao;
import br.com.spring.requisicoes.repository.LocaisRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;



public class RequisicaoForm {
    private String titulo;
    private String nome;

    @NotNull @Enumerated(EnumType.STRING)
    private RegiaoTopico regiao;

    private String populacao;

    private String capital;

    private String area;
    private String nomeRequisicao;



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeRequisicao() {
        return nomeRequisicao;
    }

    public void setNomeRequisicao(String nomeRequisicao) {
        this.nomeRequisicao = nomeRequisicao;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public RegiaoTopico getRegiao() {
        return regiao;
    }

    public void setRegiao(RegiaoTopico regiao) {
        this.regiao = regiao;
    }

    public Requisicao converter(LocaisRepository locaisRepository) {
        Locais locais = locaisRepository.findByNome(nomeRequisicao);
        return new Requisicao(nome,populacao,capital,area, locais);
    }
}
