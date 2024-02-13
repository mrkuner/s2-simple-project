package com.farasanz.web.forms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseValidatorActionForm {
	private static final long serialVersionUID = 1L;

	// Variable para hacer log
	protected final Log log = LogFactory.getLog(this.getClass());

	// Variable que indica si lo que estamos haciendo es un insert o un update
	private String operacion = "";

	// Getter y setter para la propiedad operacion
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
}