/**
 * 
 */
package com.farasanz.model;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase base de la que extienden el resto de clases.
 * @author francisco.lojo
 *
 */
public class BaseObject implements Serializable {
	private static final long serialVersionUID = 338323836593358229L;
    protected static final Logger parentLogger = LogManager.getLogger();

	/**
	 * M�todo que convierte un objeto a String y si tiene 
	 * m�s de un atributo lo escribir� de la forma atributo - valor
	 * @return un string con los todos los atributos de la clase y su valor
	 */
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
