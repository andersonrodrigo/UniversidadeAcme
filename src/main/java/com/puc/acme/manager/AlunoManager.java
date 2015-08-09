package com.puc.acme.manager;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.puc.acme.factory.FactoryBanco;
import com.puc.acme.persistence.Aluno;
import com.puc.acme.persistence.AlunoDisciplinaTurma;
import com.puc.acme.persistence.Curso;
import com.puc.acme.persistence.Disciplina;
import com.puc.acme.utils.DateUtil;

import exception.AcmeException;

@Named
@SuppressWarnings({"unchecked","rawtypes"})
public class AlunoManager {
	
	private static final DateUtil dateUtil = new DateUtil();
	private EntityManager em;
	
	public List<AlunoDisciplinaTurma> buscaNotasAlunos(String dataInicial, String dataFinal, Disciplina disciplina,
			String login) throws AcmeException {
		em = getEntityManager();
		Long idAluno = (Long) recuperaIdAluno(login).get(0);
		StringBuilder query = new StringBuilder(
				"select distinct obj from AlunoDisciplinaTurma obj left outer join obj.notas notas inner join obj.aluno aluno where aluno.id = :idAluno");
		if (dataInicial != null && !dataInicial.equals("")) {
			query.append(" and notas.data >= :dataInicial");
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			query.append(" and notas.data <= :dataFinal");
		}
		if (disciplina != null && disciplina.getId() != null) {
			query.append(" and obj.disciplinaTurma.disciplina.id = :disciplinaId");
		}
		Query q = (Query) em.createQuery(query.toString());
		q.setParameter("idAluno", idAluno);
		if (StringUtils.isNotBlank(dataInicial)) {
			q.setParameter("dataInicial", dateUtil.stringToDate(dataInicial));
		}
		if (StringUtils.isNotBlank(dataFinal)) {
			q.setParameter("dataFinal", dateUtil.stringToDate(dataFinal));
		}
		if (disciplina != null && disciplina.getId() != null) {
			q.setParameter("disciplinaId", disciplina.getId());
		}
		return q.getResultList();

	}

	public List<AlunoDisciplinaTurma> buscaNotasAlunosCoordenador(String dataInicial, String dataFinal,
			Disciplina disciplina, Aluno aluno, Curso curso, String login) throws AcmeException {
		em = getEntityManager();
		Long idCoordenador = (Long) recuperaIdCoordenador(login).get(0);
		StringBuilder query = new StringBuilder(
				"select distinct obj from AlunoDisciplinaTurma obj left outer join obj.notas notas inner join obj.aluno aluno where obj.disciplinaTurma.curso.coordenador.id = :idCoordenador");
		if (dataInicial != null && !dataInicial.equals("")) {
			query.append(" and notas.data >= :dataInicial");
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			query.append(" and notas.data <= :dataFinal");
		}
		if (disciplina != null && disciplina.getId() != null) {
			query.append(" and obj.disciplinaTurma.disciplina.id = :disciplinaId");
		}
		if (aluno != null && aluno.getId() != null) {
			query.append(" and obj.aluno.id = :alunoId");
		}
		if (curso != null && curso.getId() != null) {
			query.append(" and obj.curso.id = :cursoId");
		}
		Query q = (Query) em.createQuery(query.toString());
		q.setParameter("idCoordenador", idCoordenador);
		if (dataInicial != null && !dataInicial.equals("")) {
			q.setParameter("dataInicial", dateUtil.stringToDate(dataInicial));
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			q.setParameter("dataFinal", dateUtil.stringToDate(dataFinal));
		}
		if (disciplina != null && disciplina.getId() != null) {
			q.setParameter("disciplinaId", disciplina.getId());
		}
		if (aluno != null && aluno.getId() != null) {
			q.setParameter("alunoId", aluno.getId());
		}
		if (curso != null && curso.getId() != null) {
			q.setParameter("cursoId", curso.getId());
		}
		return q.getResultList();
	}

	public List<AlunoDisciplinaTurma> buscaNotasAlunosAtendente(String dataInicial, String dataFinal, Aluno aluno) throws AcmeException {
		em = getEntityManager();

		StringBuilder query = new StringBuilder(
				"select distinct obj from AlunoDisciplinaTurma obj left outer join obj.notas notas inner join obj.aluno aluno where  1 = 1");
		if (dataInicial != null && !dataInicial.equals("")) {
			query.append(" and notas.data >= :dataInicial");
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			query.append(" and notas.data <= :dataFinal");
		}
		if (aluno != null && aluno.getId() != null) {
			query.append(" and obj.aluno.id = :alunoId");
		}

		Query q = (Query) em.createQuery(query.toString());

		if (StringUtils.isNotBlank(dataInicial)) {
			q.setParameter("dataInicial", dateUtil.stringToDate(dataInicial));
		}
		if (StringUtils.isNotBlank(dataFinal)) {
			q.setParameter("dataFinal", dateUtil.stringToDate(dataFinal));
		}

		if (aluno != null && aluno.getId() != null) {
			q.setParameter("alunoId", aluno.getId());
		}

		return q.getResultList();
	}
	
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = FactoryBanco.getInstance().getEntityManager();
		}
		return em;
	}

	protected void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	protected List recuperaIdCoordenador(String login) {
		em = getEntityManager();
		Query query = em.createQuery("select coordenador.id from Usuario usu inner join usu.coordenador as coordenador where usu.login = :login");
		query.setParameter("login", login);
		return query.getResultList();
	}

	protected List recuperaIdAluno(String login) {
		em = getEntityManager();
		Query query = em.createQuery("select aluno.id from Usuario usu inner join usu.aluno as aluno where usu.login = :login");
		query.setParameter("login", login);
		return query.getResultList();
	}

}
