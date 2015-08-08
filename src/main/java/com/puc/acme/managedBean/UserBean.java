package com.puc.acme.managedBean;

 

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

import com.puc.acme.factory.FactoryBanco;
import com.puc.acme.manager.AlunoManager;
import com.puc.acme.persistence.Aluno;
import com.puc.acme.persistence.Usuario;
import com.puc.acme.utils.DigesterHelper;
 
 
 
@Scope("session")
@Named
@ManagedBean(name="userBo")
public class UserBean{
 
	
 
	@SuppressWarnings("unchecked")
	public String printMsgFromSpring() {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();
		String retorno = "";
		List<Aluno> listaAlunos = em.createQuery("from Aluno").getResultList();	
		for (Iterator<Aluno> iterator = listaAlunos.iterator(); iterator.hasNext();) {
			Aluno aluno = iterator.next();
			retorno = retorno + aluno.getNome() + "<BR/>";
		}
		return retorno;
	}
 
	public void saveUser(Usuario usuario){
		try{
			usuario.setSenha(criptografaSenha(usuario.getSenha()));
			//grupoUsuarioEntity.setGrupoDescricao(grupoUsuarioEntity.getGrupo().getNome());
			//grupoUsuarioEntity.setLogin(u.getLogin());
		}catch(Exception e){
			
		}
	}
	
	 /**
     * Criptografa a senha informada.
     *
     * @param senha Senha plana (sem criptografia).
     * @return Senha criptografada.
     * @throws PlcException
     */
    private String criptografaSenha(String senha) throws Exception {
        try {
            return DigesterHelper.digest("SHA", senha);

        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e);
        }
    }
    
    /**
     * 
     */
    public void desloga(){
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	request.getSession().invalidate();
    	FacesContext context = FacesContext.getCurrentInstance();

    	NavigationHandler navHandler = context.getApplication().getNavigationHandler();

    	navHandler.handleNavigation(context, null, "logout");	
   
    }
    
    /**
     * 
     * @return
     */
    public Boolean  perfilAluno(){
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.isUserInRole("Aluno");	
    }
    /**
     * 
     * @return
     */
    public Boolean  perfilCoordenador(){
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.isUserInRole("Coordenador");	
    }
    /**
     * 
     * @return
     */
    public Boolean  perfilAtendente(){
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.isUserInRole("Atendente");	
    }
    
    public String nomeUsuario(){
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
    	return request.getUserPrincipal().getName();
    }

}