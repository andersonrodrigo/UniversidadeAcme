package com.puc.acme.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.junit.Before;
import org.junit.Test;

import com.puc.acme.persistence.Aluno;

public class ComboAppTest {
	
	private ComboApp util;
	
	@Before
	public void setUp() throws Exception {
		util = new ComboApp();
	}

	@Test
	public void testaTransformacaoEmSelectItems() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setId(1L);
		a1.setNome("a1");
		
		a2.setId(2L);
		a2.setNome("a2");
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(a1);
		alunos.add(a2);
		
		List<SelectItem> itensAluno = util.transformaSelectItens(alunos);
		
		assertThat(itensAluno, hasSize(2));
		
		assertThat(itensAluno.get(0).getLabel(), is(a1.getNome()));
		assertThat((Long)itensAluno.get(0).getValue(), is(a1.getId()));
		
		assertThat(itensAluno.get(1).getLabel(), is(a2.getNome()));
		assertThat((Long)itensAluno.get(1).getValue(), is(a2.getId()));
	}

}
