package com.puc.acme.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.puc.acme.factory.FactoryBanco;
import com.puc.acme.persistence.Aluno;
import com.puc.acme.persistence.AlunoDisciplinaTurma;
import com.puc.acme.persistence.Curso;
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
	public List<AlunoDisciplinaTurma> buscaNotasAlunos(String dataInicial, String dataFinal, Disciplina disciplina,
			String login) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();
		Long idAluno = recuperaIdAluno(login);
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
		if (dataInicial != null) {
			q.setParameter("dataInicial", montaData(dataInicial));
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			q.setParameter("dataFinal", montaData(dataFinal));
		}
		if (disciplina != null && disciplina.getId() != null) {
			q.setParameter("disciplinaId", disciplina.getId());
		}
		return q.getResultList();

	}

	/**
	 * 
	 * @param dataInicial
	 * @return
	 */
	private Date montaData(String dataInicial) {
		// TODO Auto-generated method stub
		Date data = null;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
		} catch (Exception e) {

		}
		return data;
	}

	/**
	 * 
	 * @param login
	 * @return
	 */
	private Long recuperaIdCoordenador(String login) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();

		return (Long) em
				.createQuery(
						"select coordenador.id from Usuario usu inner join usu.coordenador as coordenador where usu.login = :login")
				.setParameter("login", login).getResultList().get(0);
	}

	/**
	 * 
	 * @param login
	 * @return
	 */
	private Long recuperaIdAluno(String login) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();

		return (Long) em
				.createQuery("select aluno.id from Usuario usu inner join usu.aluno as aluno where usu.login = :login")
				.setParameter("login", login).getResultList().get(0);
	}

	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @param disciplina
	 * @param aluno
	 * @param curso
	 * @param name
	 * @return
	 */
	public List<AlunoDisciplinaTurma> buscaNotasAlunosCoordenador(String dataInicial, String dataFinal,
			Disciplina disciplina, Aluno aluno, Curso curso, String login) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();
		Long idCoordenador = recuperaIdCoordenador(login);
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
			q.setParameter("dataInicial", montaData(dataInicial));
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			q.setParameter("dataFinal", montaData(dataFinal));
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

	public List<AlunoDisciplinaTurma> buscaNotasAlunosAtendente(String dataInicial, String dataFinal, Aluno aluno) {
		EntityManager em = FactoryBanco.getInstance().getEntityManager();

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

		if (dataInicial != null && !dataInicial.equals("")) {
			q.setParameter("dataInicial", montaData(dataInicial));
		}
		if (dataFinal != null && !dataFinal.equals("")) {
			q.setParameter("dataFinal", montaData(dataFinal));
		}

		if (aluno != null && aluno.getId() != null) {
			q.setParameter("alunoId", aluno.getId());
		}

		return q.getResultList();
	}

}
