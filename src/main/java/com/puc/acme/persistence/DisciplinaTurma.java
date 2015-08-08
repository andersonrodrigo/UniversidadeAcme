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
@Table(name = "DisciplinaTurma")
public class DisciplinaTurma {

	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Turma turma;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Disciplina disciplina;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Curso curso;

	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
