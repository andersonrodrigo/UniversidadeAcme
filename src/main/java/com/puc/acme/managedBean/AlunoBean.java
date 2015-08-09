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

import exception.AcmeException;


@Scope("session")
@Named
@ManagedBean(name="alunoBean")
 public class AlunoBean {

	@Autowired(required=false)
	private AlunoManager alunoManager;

	private List<AlunoDisciplinaTurma> listaResultado;
	
	private Disciplina disciplina;
	
	private String dataInicial;
	
	private String dataFinal;

	public List<AlunoDisciplinaTurma> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<AlunoDisciplinaTurma> listaResultado) {
		this.listaResultado = listaResultado;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public void apresentaNotasAluno() throws AcmeException{
		
		disciplina = new Disciplina();
			
    	FacesContext context = FacesContext.getCurrentInstance();

    	NavigationHandler navHandler = context.getApplication().getNavigationHandler();

    	listaResultado = pesquisaNotasAluno();
    	
    	navHandler.handleNavigation(context, null, "apresentaNotas");	
	}

	private List<AlunoDisciplinaTurma> pesquisaNotasAluno() throws AcmeException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	 
		return getAlunoManager().buscaNotasAlunos(dataInicial,dataFinal,disciplina,request.getUserPrincipal().getName());
	}

	public String pesquisa() throws AcmeException{
		listaResultado = pesquisaNotasAluno();
		return null;
	}

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
