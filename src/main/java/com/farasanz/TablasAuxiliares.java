package com.farasanz;
/**
 * Clase que ser� la contenedora de las listas que se utilicen en la aplicaci�n
 */
public class TablasAuxiliares {
	/**
	 * Variable que define el c�digo que representa a la caracter�stica
	 */
		    private String codigo ;
	/**
	 * Descriptor del c�digo de una determinada caracter�stica
	 */	    
		    private String descriptor ;
	/**
	 * M�todo que asigna al atributo c�digo un nuevo valor
	 * @param codigo Literal que contiene el nuevo c�digo para el atributo
	 */
		    public void setCodigo(String codigo) {
		        this.codigo = codigo;
		    }
	/**
	 * M�todo que obtiene el valor actual de la propiedad c�digo
	 * @return String literal con el c�digo actual
	 */
		    public String getCodigo() {
		        return codigo;
		    }
	/**
	 * M�todo que se ocupa de introducir un nuevo valor en la propiedad descriptor
	 * @param descriptor Literal con el nuevo valor para el atributo
	 */
		    public void setDescriptor(String descriptor) {
		        this.descriptor = descriptor;
		    }
	/**
	 * M�todo que obtiene el valor actual de la propiedad descriptor
	 * @return String literal con el valor actual de la carater�stica descriptor
	 */
		    public String getDescriptor() {
		        return descriptor;
		    }
}
