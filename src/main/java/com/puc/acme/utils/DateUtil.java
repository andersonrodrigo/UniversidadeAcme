package com.puc.acme.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import exception.AcmeException;

public class DateUtil {
	
	private static final String ERROR_MSG = "Erro ao formatar data %s ";
	private static final String DATE_MASK = "dd/MM/yyyy";

	public Date stringToDate(String dataInicial) throws AcmeException {
		Date data = null;
		try {
			data = new SimpleDateFormat(DATE_MASK).parse(dataInicial);
		} catch (Exception e) {
			throw new AcmeException(String.format(ERROR_MSG, dataInicial), e);
		}
		return data;
	}
	
}
