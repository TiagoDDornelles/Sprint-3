package br.com.spring.requisicoes.controller.dto;

import br.com.spring.requisicoes.modelo.RegiaoTopico;
import br.com.spring.requisicoes.modelo.Requisicao;

import java.util.List;
import java.util.stream.Collectors;


public class RequisicaoDto {

    private Long id;
    private  String nome;

    private RegiaoTopico regiao;
    private  String populacao;

    private  String capital;

    private  String area;

    public RequisicaoDto(Requisicao requisicao){
        this.id = requisicao.getId();
        this.nome = requisicao.getNome();
        this.regiao = requisicao.getRegiao();
        this.populacao = requisicao.getPopulacao();
        this.capital = requisicao.getCapital();
        this.area = requisicao.getArea();

    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public String getArea() {
        return area;
    }

    public RegiaoTopico getRegiao() {
        return regiao;
    }

    public static List<RequisicaoDto> converter(List<Requisicao> requisicaos) {
        return requisicaos.stream().map(RequisicaoDto::new).collect(Collectors.toList());
    }
}
