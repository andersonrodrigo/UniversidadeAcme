package com.puc.acme.persistence;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Notas")
public class Notas {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date data;
	
	@Column(name="valorAtividade")
	private BigDecimal valorAtividade;
	
	@Column(name="valorObtido")
	private BigDecimal valorObtido;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private AlunoDisciplinaTurma alunoDisciplinaTurma;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public BigDecimal getValorAtividade() {
		return valorAtividade;
	}


	public void setValorAtividade(BigDecimal valorAtividade) {
		this.valorAtividade = valorAtividade;
	}


	public BigDecimal getValorObtido() {
		return valorObtido;
	}


	public void setValorObtido(BigDecimal valorObtido) {
		this.valorObtido = valorObtido;
	}


	public AlunoDisciplinaTurma getAlunoDisciplinaTurma() {
		return alunoDisciplinaTurma;
	}


	public void setAlunoDisciplinaTurma(AlunoDisciplinaTurma alunoDisciplinaTurma) {
		this.alunoDisciplinaTurma = alunoDisciplinaTurma;
	}
	
	
	

}
