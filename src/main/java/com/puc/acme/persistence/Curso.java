package com.puc.acme.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Curso")
public class Curso {
	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;


	@Column(name = "nome")
	private String nome;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Coordenador coordenador;

	
	public Coordenador getCoordenador() {
		return coordenador;
	}


	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
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

	
}
