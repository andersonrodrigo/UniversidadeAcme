package com.puc.acme.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.puc.acme.factory.FactoryBanco;
public class ConfiguraApp implements ServletContextListener  {
	
	  @Override
		public void contextDestroyed(ServletContextEvent arg0) {
			System.out.println("Derrubando a aplica��o");
		}
	 
	      //Run this before web application is started
	    @Override
	    public void contextInitialized(ServletContextEvent arg0) {
	           System.out.println("Iniciando a aplica��o");
	        try {
	            if (FactoryBanco.getInstance(arg0.getServletContext().getInitParameter("jndiBanco")).isInited()){
	                    System.out.println("Banco iniado");    
	            }else{
	                System.out.println("Erro ao iniciar banco");    
	            }
	        } catch (Exception ex) {
	           ex.printStackTrace();
	        }
	    }

}
