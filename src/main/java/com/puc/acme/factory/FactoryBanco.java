package com.puc.acme.factory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;


public class FactoryBanco {
 
	private static FactoryBanco INSTANCE = null;
	private EntityManager entityManager;
    private EntityManagerFactory factory;
     
    
	private FactoryBanco(String persistenceUnitName){
		factory = Persistence.createEntityManagerFactory(persistenceUnitName!=null?persistenceUnitName:"JUniversidadeAcme");
		 this.entityManager = factory.createEntityManager();
	}
	public static FactoryBanco getInstance(String persistenceUnitName ) {
		if (INSTANCE==null){
			INSTANCE = new FactoryBanco(persistenceUnitName);
		}
		return INSTANCE;
	}
	public static FactoryBanco getInstance() {
		if (INSTANCE==null){
			INSTANCE = new FactoryBanco(null);
		}
		return INSTANCE;
	}
	public boolean isInited(){
		Session sess = null;
		try{
			sess = (Session) entityManager.getDelegate();
			sess.beginTransaction();
			return sess.isConnected();
		}catch(Exception e ){
			if (sess!=null){
				sess.disconnect();
			}
		}
		return false;
	}
    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }
     
    public void commit(){
        entityManager.getTransaction().commit();
    }
     
    /**
     * THIS METHOD NEEDS TO BE ALWAYS CALLED
     */
    public void close(){
        entityManager.close();
        factory.close();
    }
     
    public void rollBack(){
        entityManager.getTransaction().rollback();
    }
     
    public EntityManager getEntityManager(){
        return entityManager;
    }
}
