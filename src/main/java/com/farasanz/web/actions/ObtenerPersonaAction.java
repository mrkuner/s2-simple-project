package com.farasanz.web.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.farasanz.model.Persona;
import com.farasanz.services.IPersonaServicio;
import com.farasanz.util.Constantes;

public class ObtenerPersonaAction extends BaseAction {
	private static final long serialVersionUID = 5113321258228141906L;
	
	@Autowired private IPersonaServicio personaServicio;

	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public String execute() throws Exception {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.persona =new Persona();
		
		if (id != null && !id.equalsIgnoreCase("")) {
			this.persona.setId(Integer.parseInt(id));
			this.persona=personaServicio.obtener(persona);
		}
		
		return Constantes.EXITO_FORWARD;
	}
	
}
