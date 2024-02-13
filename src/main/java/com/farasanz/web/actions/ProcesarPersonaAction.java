package com.farasanz.web.actions;

import com.farasanz.model.Persona;
import com.farasanz.services.IPersonaServicio;
import com.farasanz.util.Constantes;

public class ProcesarPersonaAction extends BaseAction {
	private static final long serialVersionUID = -5661722915725795824L;
	private IPersonaServicio personaServicio;
	
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void setPersonaServicio(IPersonaServicio personaServicio) {
		this.personaServicio = personaServicio;
	}
	
	public String execute() throws Exception {
		personaServicio.actualizar(persona);
		return Constantes.EXITO_FORWARD;	
	}
}
