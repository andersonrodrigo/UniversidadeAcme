package com.puc.acme.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenador")
public class Coordenador {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;


	@Column(name = "nome")
	private String nome;


	 


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
