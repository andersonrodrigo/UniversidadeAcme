package com.puc.acme.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Perfil")
public class Perfil {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;


	@Column(name = "nome")
	private String nome;

	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="perfil")
	private List<FuncionalidadePerfil> funcionalidades;
	
	

	public List<FuncionalidadePerfil> getFuncionalidades() {
		return funcionalidades;
	}


	public void setFuncionalidades(List<FuncionalidadePerfil> funcionalidades) {
		this.funcionalidades = funcionalidades;
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
