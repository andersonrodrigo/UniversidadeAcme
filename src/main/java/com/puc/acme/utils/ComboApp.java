package com.puc.acme.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;

import org.apache.commons.beanutils.PropertyUtils;

import com.puc.acme.factory.FactoryBanco;

@ApplicationScoped
@ManagedBean(name = "ComboApp")
public class ComboApp {

	private String[] objetosCombo = new String[] { "Aluno", "Disciplina", "Curso" };

	@SuppressWarnings("rawtypes")
	private HashMap<String, List> mapaCambos;

	public void carregaCombos() {
		mapaCambos = new HashMap<String, List>();
		EntityManager em = FactoryBanco.getInstance().getEntityManager();
		for (int i = 0; i < objetosCombo.length; i++) {
			try {
				mapaCambos.put(objetosCombo[i].toString(), transformaSelectItens(listaObjetos(em, objetosCombo[i])));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param classe
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SelectItem> recuperaCombo(String classe) {
		if (mapaCambos == null) {
			carregaCombos();
		}
		return mapaCambos.get(classe);
	}

	/**
	 * 
	 * @param listaObjetos
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private List transformaSelectItens(List listaObjetos)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List listaRetorno = new ArrayList();
		if (listaObjetos != null && !listaObjetos.isEmpty()) {
			for (Object object : listaObjetos) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(PropertyUtils.getProperty(object, "id"));
				selectItem.setLabel(object.toString());
				listaRetorno.add(selectItem);
			}
		}
		return listaRetorno;
	}

	/**
	 * 
	 * @param em
	 * @param obj
	 * @return
	 */
	private List listaObjetos(EntityManager em, String obj) {

		return em.createQuery("from " + obj).getResultList();
	}

	public HashMap<String, List> getMapaCambos() {
		if (mapaCambos == null) {
			carregaCombos();
		}
		return mapaCambos;
	}

	public void setMapaCambos(HashMap<String, List> mapaCambos) {
		this.mapaCambos = mapaCambos;
	}

	public String[] getObjetosCombo() {
		return objetosCombo;
	}

	public void setObjetosCombo(String[] objetosCombo) {
		this.objetosCombo = objetosCombo;
	}

}
