package com.puc.acme.managedBean;

 

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.springframework.context.annotation.Scope;

import com.puc.acme.factory.FactoryBanco;
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
			retorno = aluno.getNome();
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

}