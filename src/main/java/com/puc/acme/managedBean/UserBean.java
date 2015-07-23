package com.puc.acme.managedBean;

 

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.springframework.context.annotation.Scope;

import com.puc.acme.factory.FactoryBanco;
import com.puc.acme.persistence.Aluno;
 
 
 
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
 
}