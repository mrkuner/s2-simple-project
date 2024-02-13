package com.farasanz;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;


/**
 * Bean que contiene los datos para el funcionamiento de la aplicaci�n y que
 * estar� activo mientras �sta lo est�
 */
public class AplicacionBean {

	/**
	 * Lista de las empresas
	 */
	private ArrayList<TablasAuxiliares> listaEmpresas;
	
	/**
	 * Lista de los tipos de servicio
	 */
	private ArrayList<TablasAuxiliares> listaTipoServicios;

	/**
	 * @return the listaTipoServicios
	 */
	public ArrayList<TablasAuxiliares> getListaTipoServicios() {
		return listaTipoServicios;
	}

	/**
	 * @param listaTipoServicios the listaTipoServicios to set
	 */
	public void setListaTipoServicios(ArrayList<TablasAuxiliares> listaTipoServicios) {
		this.listaTipoServicios = listaTipoServicios;
	}

	/**
	 * @return the listaEmpresas
	 */
	public ArrayList<TablasAuxiliares> getListaEmpresas() {
		return listaEmpresas;
	}

	/**
	 * @param listaEmpresas the listaEmpresas to set
	 */
	public void setListaEmpresas(ArrayList<TablasAuxiliares> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}
	
	private ApplicationContext applicationContext = null;
	
	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
}