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
@Table(name = "FuncionalidadePerfil")
public class FuncionalidadePerfil {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Perfil perfil;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Funcionalidade Funcionalidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Funcionalidade getFuncionalidade() {
		return Funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		Funcionalidade = funcionalidade;
	}

}
