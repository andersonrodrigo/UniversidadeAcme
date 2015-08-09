package com.puc.acme.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.puc.acme.utils.DateUtil;

import exception.AcmeException;
import junit.framework.Assert;

public class DateUtilTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	private DateUtil util;
	
	@Before
	public void setUp() throws Exception {
		util = new DateUtil();
	}

	@Test
	public void lancaExcecaoAoFormatarDataNula() throws AcmeException {
		expectedException.expect(AcmeException.class);
		expectedException.expectMessage("Erro ao formatar data null ");
		util.stringToDate(null);
	}
	
	@Test
	public void formataData() throws AcmeException {
		Date data = util.stringToDate("1/1/1990");
		Calendar cal = Calendar.getInstance(new Locale("pt","BR"));
		cal.setTime(data);
		Assert.assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(0, cal.get(Calendar.MONTH));//0 Based
		Assert.assertEquals(1990, cal.get(Calendar.YEAR));
	}

}
