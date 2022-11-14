package br.com.spring.requisicoes.modelo;

import javax.persistence.*;

@Entity
public class Requisicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	@Enumerated(EnumType.STRING)
	private RegiaoTopico regiao;

	private String populacao;

	private String capital;

	private String area;
	@ManyToOne
	private Locais locais;


	public Requisicao(){

	}

	public Requisicao(String nome, String populacao, String capital, String area, Locais locais) {
		this.nome = nome;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;
		this.locais = locais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requisicao other = (Requisicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Locais getLocais() {
		return locais;
	}

	public void setLocais(Locais locais) {
		this.locais = locais;
	}

}
