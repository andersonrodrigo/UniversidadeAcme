package com.puc.acme.manager;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.puc.acme.persistence.Aluno;
import com.puc.acme.persistence.Coordenador;
import com.puc.acme.persistence.Curso;
import com.puc.acme.persistence.Disciplina;
import com.puc.acme.utils.DateUtil;

import exception.AcmeException;

@SuppressWarnings("rawtypes")
public class AlunoManagerTest {
	
	private static final String LOGIN_TESTE = "testeLogin";
	private static final long ID_CURSO = 100L;
	private static final long ID_DISCIPLINA = 5L;
	private static final long ID_COORDENADOR = 1000L;
	private static final long ID_ALUNO = 10L;
	private static final String DATA_FINAL = "01/01/1901";
	private static final String DATA_INICIAL = "01/01/1900";

	@Spy private AlunoManager manager = new AlunoManager();
	@Mock private EntityManager em;
	@Mock private Query q;

	private Disciplina disciplina;
	private Aluno aluno;
	private Curso curso;
	private DateUtil dateUtil;
	private Coordenador coordenador;

	@Before
	public void prepare() {
		dateUtil = new DateUtil();
		MockitoAnnotations.initMocks(this);
		
		coordenador = new Coordenador();
		coordenador.setId(ID_COORDENADOR);
		coordenador.setNome("teste coordenador");
		
		disciplina = new Disciplina();
		disciplina.setId(ID_DISCIPLINA);
		disciplina.setNome("Teste");
		
		aluno = new Aluno();
		aluno.setId(ID_ALUNO);
		aluno.setNome("teste");
		
		curso = new Curso();
		curso.setId(ID_CURSO);
		curso.setNome("testeCurso");
		curso.setCoordenador(coordenador);
		
		manager.setEntityManager(em);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(q);
		Mockito.when(q.getResultList()).thenReturn(new ArrayList());
		Mockito.when(manager.recuperaIdAluno(Mockito.anyString())).thenReturn(Arrays.asList(new Long[]{ID_ALUNO}));
		Mockito.when(manager.recuperaIdCoordenador(Mockito.anyString())).thenReturn(Arrays.asList(new Long[]{ID_COORDENADOR}));
	}
	
	@Test
	public void testaBuscaNotasAlunosPassagemTodosParametrosConsulta() throws AcmeException {
		manager.buscaNotasAlunos(DATA_INICIAL, DATA_FINAL, disciplina, LOGIN_TESTE);
		Mockito.verify(q, Mockito.times(1)).setParameter("idAluno", 1000L);
		Mockito.verify(q, Mockito.times(1)).setParameter("dataInicial",dateUtil.stringToDate(DATA_INICIAL));
		Mockito.verify(q, Mockito.times(1)).setParameter("dataFinal", dateUtil.stringToDate(DATA_FINAL));
		Mockito.verify(q, Mockito.times(1)).setParameter("disciplinaId", disciplina.getId());
	}
	
	@Test
	public void testaBuscaNotasAlunosPassagemApenasAlunoId() throws AcmeException {
		manager.buscaNotasAlunos(null, null, null, LOGIN_TESTE);
		Mockito.verify(q, Mockito.times(1)).setParameter("idAluno", 1000L);
		Mockito.verify(q, Mockito.times(0)).setParameter("dataInicial",dateUtil.stringToDate(DATA_INICIAL));
		Mockito.verify(q, Mockito.times(0)).setParameter("dataFinal", dateUtil.stringToDate(DATA_FINAL));
		Mockito.verify(q, Mockito.times(0)).setParameter("disciplinaId", disciplina.getId());
	}
	
	@Test
	public void testaBuscaNotasAlunosAtendentePassagemTodosParametrosConsulta() throws AcmeException {
		manager.buscaNotasAlunosAtendente(DATA_INICIAL, DATA_FINAL, aluno);
		Mockito.verify(q, Mockito.times(1)).setParameter("alunoId", ID_ALUNO);
		Mockito.verify(q, Mockito.times(1)).setParameter("dataInicial",dateUtil.stringToDate(DATA_INICIAL));
		Mockito.verify(q, Mockito.times(1)).setParameter("dataFinal", dateUtil.stringToDate(DATA_FINAL));
	}
	
	@Test
	public void testaBuscaNotasAlunosAtendentePassagemNenhumParametroConsulta() throws AcmeException {
		manager.buscaNotasAlunosAtendente(null, null, null);
		Mockito.verify(q, Mockito.times(0)).setParameter("alunoId", ID_ALUNO);
		Mockito.verify(q, Mockito.times(0)).setParameter("dataInicial",dateUtil.stringToDate(DATA_INICIAL));
		Mockito.verify(q, Mockito.times(0)).setParameter("dataFinal", dateUtil.stringToDate(DATA_FINAL));
	}
	
	@Test
	public void testaBuscaNotasAlunosCoordenadorPassagemTodosParametrosConsulta() throws AcmeException {
		manager.buscaNotasAlunosCoordenador(DATA_INICIAL, DATA_FINAL, disciplina, aluno, curso, LOGIN_TESTE);
		Mockito.verify(q, Mockito.times(1)).setParameter("idCoordenador", ID_COORDENADOR);
		Mockito.verify(q, Mockito.times(1)).setParameter("dataInicial",dateUtil.stringToDate(DATA_INICIAL));
		Mockito.verify(q, Mockito.times(1)).setParameter("dataFinal", dateUtil.stringToDate(DATA_FINAL));
		Mockito.verify(q, Mockito.times(1)).setParameter("disciplinaId", ID_DISCIPLINA);
		Mockito.verify(q, Mockito.times(1)).setParameter("alunoId", ID_ALUNO);
		Mockito.verify(q, Mockito.times(1)).setParameter("cursoId", ID_CURSO);
	}
	
	@Test
	public void testaBuscaNotasAlunosCoordenadorPassagemApenasIdCoordenadorConsulta() throws AcmeException {
		manager.buscaNotasAlunosCoordenador(null, null, null, null, null, LOGIN_TESTE);
		Mockito.verify(q, Mockito.times(1)).setParameter("idCoordenador", ID_COORDENADOR);
		Mockito.verify(q, Mockito.times(0)).setParameter("dataInicial",dateUtil.stringToDate(DATA_INICIAL));
		Mockito.verify(q, Mockito.times(0)).setParameter("dataFinal", dateUtil.stringToDate(DATA_FINAL));
		Mockito.verify(q, Mockito.times(0)).setParameter("disciplinaId", ID_DISCIPLINA);
		Mockito.verify(q, Mockito.times(0)).setParameter("alunoId", ID_ALUNO);
		Mockito.verify(q, Mockito.times(0)).setParameter("cursoId", ID_CURSO);

	}

}
