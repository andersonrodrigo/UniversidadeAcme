package com.puc.acme.persistence;
import javax.persistence.*;

@Entity
@Table(name = "Aluno")
public class Aluno {

	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;


	@Column(name = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}
}
