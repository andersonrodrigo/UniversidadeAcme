package com.puc.acme.persistence;
import javax.persistence.*;

@Entity
@Table(name = "Aluno")
public class Aluno {
	
	 @Id @GeneratedValue
	   @Column(name = "id")
	   private int id;

	 
	 @Column(name = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
