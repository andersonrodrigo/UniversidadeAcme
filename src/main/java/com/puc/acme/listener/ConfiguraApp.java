package com.puc.acme.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.puc.acme.factory.FactoryBanco;

public class ConfiguraApp implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Derrubando a aplicação");
	}

	// Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Iniciando a aplicação");
		try {
			if (FactoryBanco.getInstance(arg0.getServletContext().getInitParameter("jndiBanco")).isInited()) {
				System.out.println("Banco iniciado");
			} else {
				System.out.println("Erro ao iniciar banco");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
