package com.farasanz.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


/**
 * Bean que contiene todos los datos necesarios para tener en cuenta y accesibles
 * en el transcurso de una sesi�n, estar� activo el tiempo que dure �sta
 */
public class SesionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7928968927479271117L;
	
	
	/**
	 * Guarda los datos en el bean de la sesi�n 
	 * @param request la peticion http
	 */	
	public void escribirASesion( HttpServletRequest request ){
		request.getSession().setAttribute(Constantes.SESION_BEAN  , this);
	}
	
	/**
	 * Lee los datos del bean de la sesi�n 
	 * @param request la peticion http
	 */	
	public SesionBean leerDeSesion(HttpServletRequest request){
		return (SesionBean) request.getSession().getAttribute(Constantes.SESION_BEAN);
	}


}
