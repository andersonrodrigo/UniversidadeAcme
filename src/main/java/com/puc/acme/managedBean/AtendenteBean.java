package com.puc.acme.managedBean;

import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.puc.acme.manager.AlunoManager;
import com.puc.acme.persistence.Aluno;
import com.puc.acme.persistence.AlunoDisciplinaTurma;

@Scope("session")
@Named
@ManagedBean(name = "alunoBean")
public class AtendenteBean {

	@Autowired(required = false)
	AlunoManager alunoManager;

	/**
	 * Atributos do MB
	 */

	private List<AlunoDisciplinaTurma> listaResultado;

	private Aluno aluno;

	private String dataInicial;

	private String dataFinal;

	/**
	 * Gets e Sets
	 * 
	 */

	/**
	 * 
	 * @return
	 */
	public List<AlunoDisciplinaTurma> getListaResultado() {
		return listaResultado;
	}

	/**
	 * 
	 * @param listaResultado
	 */
	public void setListaResultado(List<AlunoDisciplinaTurma> listaResultado) {
		this.listaResultado = listaResultado;
	}

	/**
	 * 
	 * @return
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * 
	 * @param aluno
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * 
	 * @return
	 */
	public String getDataInicial() {
		return dataInicial;
	}

	/**
	 * 
	 * @param dataInicial
	 */
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * 
	 * @return
	 */
	public String getDataFinal() {
		return dataFinal;
	}

	/**
	 * 
	 * @param dataFinal
	 */
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * 
	 */
	public void apresentaNotasAluno() {

		aluno = new Aluno();

		FacesContext context = FacesContext.getCurrentInstance();

		NavigationHandler navHandler = context.getApplication().getNavigationHandler();

		listaResultado = pesquisaNotasAluno();

		navHandler.handleNavigation(context, null, "apresentaNotasAtendente");
	}

	/**
	 * 
	 * @return
	 */
	private List<AlunoDisciplinaTurma> pesquisaNotasAluno() {
		return getAlunoManager().buscaNotasAlunosAtendente(dataInicial, dataFinal, aluno);
	}

	/**
	 * 
	 * @return
	 */
	public String pesquisa() {
		listaResultado = pesquisaNotasAluno();
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public AlunoManager getAlunoManager() {
		if (alunoManager == null) {
			alunoManager = new AlunoManager();
		}
		return alunoManager;
	}

	/**
	 * 
	 * @param alunoManager
	 */
	public void setAlunoManager(AlunoManager alunoManager) {
		this.alunoManager = alunoManager;
	}

}
