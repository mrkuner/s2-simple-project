/**
 * 
 */
package com.farasanz.exceptions;

import java.util.ArrayList;

/**
 * Excepci�n que representa los errores controlados de la aplicaci�n.
 * Cada uno de los errores que se almacene deber�a ser almacenado en la excepci�n con una
 * clave para que sea manejado posteriormente por el cliente y se permita la internacionalizacion
 * @author francisco.lojo
 *
 */
public class AppException extends Exception {
	
	/**
	 * Lista de errores que han sucedido para una determinada petici�n
	 */
	private ArrayList<String> errores;
	
	/**
	 * Constructor por defecto.
	 */
	public AppException(){
		super();
	}
	
	/**
	 * Constructor que toma como parametro un error que haya sucedido en la aplicaci�n.
	 * @param error El error que se haya producido.
	 */
	public AppException(String error){
		this.addError(error);
	}
	
	/**
	 * Constructor que toma como parametro una lista de errores que hayan sucedido en la aplicaci�n
	 * @param listaErrores La lista conteniendo los errores.
	 */
	public AppException(ArrayList<String> listaErrores){
		this.setErrores(listaErrores);
	}
	
	
	/**
	 * A�ade una error a la lista de errores de la excepcion, haciendo la inicializacion
	 * que sean necesarias.
	 * @param error La clave del error que se haya producido.
	 */
	public void addError(String error){
		
		// inicializamos la lista de errores si es necesario.
		this.inicializaListaErrores();
		errores.add(error);
	}
	
	/**
	 * A�ade una lista de errores a la excepcion haciendo las inicializaciones que sean
	 * necesarias
	 * @param listaErrores Lista conteniendo los errores que se a�aden a la lista.
	 */
	public void setErrores(ArrayList<String> listaErrores){
		this.inicializaListaErrores();
		this.errores.addAll(listaErrores);
	}
	
	/**
	 * Devuelve la lista de errores producidos y almacenadas en la excepci�n
	 * En caso de no haberse producido ninguna devuelve una lista vacia.
	 */
	public ArrayList<String> getErrores(){
		if ( this.errores == null){
			this.errores = new ArrayList<String>();
		}
		return this.errores; 
	}
	
	/**
	 * Inicializa la lista de errores en el caso de que esta no haya sido previamente
	 * inicializada.
	 */
	private void inicializaListaErrores(){
		if ( this.errores == null ){
			errores = new ArrayList<String>();
		}
	}

}
