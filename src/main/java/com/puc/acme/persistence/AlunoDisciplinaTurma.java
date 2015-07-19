package com.puc.acme.persistence;

 

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AlunoDisciplinaTurma")
public class AlunoDisciplinaTurma {
	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;

	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Aluno aluno;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private DisciplinaTurma disciplinaTurma;
	
	@Column(name = "status")
	private String status;

	 
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="alunoDisciplinaTurma",fetch=FetchType.EAGER,targetEntity=Notas.class)	
	private List<Notas> notas;
	
	
	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public DisciplinaTurma getDisciplinaTurma() {
		return disciplinaTurma;
	}

	public void setDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		this.disciplinaTurma = disciplinaTurma;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
