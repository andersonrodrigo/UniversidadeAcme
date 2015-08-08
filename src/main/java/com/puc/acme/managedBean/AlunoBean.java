package com.puc.acme.managedBean;

import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.puc.acme.manager.AlunoManager;
import com.puc.acme.persistence.AlunoDisciplinaTurma;
import com.puc.acme.persistence.Disciplina;


@Scope("session")
@Named
@ManagedBean(name="alunoBean")
 public class AlunoBean {
	
	 
	@Autowired(required=false)
	AlunoManager alunoManager;
	
	/**
	 * Atributos do MB
	 */
	
	private List<AlunoDisciplinaTurma> listaResultado;
	
	private Disciplina disciplina;
	
	private String dataInicial;
	
	private String dataFinal;
	
 
	
	
	/**Gets e Sets
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
	public Disciplina getDisciplina() {
		return disciplina;
	}

	/**
	 * 
	 * @param disciplina
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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
	public void apresentaNotasAluno(){
		
		disciplina = new Disciplina();
			
    	FacesContext context = FacesContext.getCurrentInstance();

    	NavigationHandler navHandler = context.getApplication().getNavigationHandler();

    	listaResultado = pesquisaNotasAluno();
    	
    	navHandler.handleNavigation(context, null, "apresentaNotas");	
	}



	/**
	 * 
	 * @return
	 */
	private List<AlunoDisciplinaTurma> pesquisaNotasAluno() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	 
		return getAlunoManager().buscaNotasAlunos(dataInicial,dataFinal,disciplina,request.getUserPrincipal().getName());
	}
	
 
	/**
	 * 
	 * @return
	 */
	public String pesquisa(){
		listaResultado =pesquisaNotasAluno();
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public AlunoManager getAlunoManager() {
		if (alunoManager==null){
			alunoManager = new AlunoManager();
		}
		return alunoManager;
	}

	public void setAlunoManager(AlunoManager alunoManager) {
		this.alunoManager = alunoManager;
	}

}
