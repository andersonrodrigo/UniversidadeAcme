package com.puc.acme.manager;

import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.puc.acme.factory.FactoryBanco;
import com.puc.acme.persistence.AlunoDisciplinaTurma;
import com.puc.acme.persistence.Disciplina;

@Named

public class AlunoManager {

	
	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @param disciplina
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AlunoDisciplinaTurma> buscaNotasAlunos(Date dataInicial,
			Date dataFinal, Disciplina disciplina, String login) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();
		Long idAluno = recuperaIdAluno(login);
		StringBuilder query = new StringBuilder("select distinct obj from AlunoDisciplinaTurma obj left outer join obj.notas notas inner join obj.aluno aluno where aluno.id = :idAluno");
		if (dataInicial!=null){
			query.append(" and notas.data > :dataInicial");
		}
		if (dataFinal!=null){
			query.append(" and notas.data < :dataFinal");
		}
		if (disciplina!=null){
			query.append(" and obj.disciplinaTurma.disciplina.id = :disciplinaId");
		}
		Query q = (Query) em.createQuery(query.toString());
		q.setParameter("idAluno", idAluno);
		if (dataInicial!=null){
			q.setParameter("dataInicial", dataInicial);
		}
		if (dataFinal!=null){
			q.setParameter("dataFinal", dataFinal);
		}
		if (disciplina!=null){
			q.setParameter("disciplinaId", disciplina.getId());
		}
		return q.getResultList();	
	 
	}

	/**
	 * 
	 * @param login
	 * @return
	 */
	private Long recuperaIdAluno(String login) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();
		
		return (Long )em.createQuery("select aluno.id from Usuario usu inner join usu.aluno as aluno where usu.login = :login")
				.setParameter("login", login).getResultList().get(0);
	}

}
