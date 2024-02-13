package com.farasanz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farasanz.dao.IPersonaDao;
import com.farasanz.exceptions.AppException;
import com.farasanz.model.Persona;
import com.farasanz.services.IPersonaServicio;

@Service
public class PersonaServicio implements IPersonaServicio {

	@Autowired private IPersonaDao personaDao;
	
	public Persona obtener(Persona persona) throws AppException {		
		return personaDao.obtener(persona);				
	}
		
	public void actualizar(Persona persona)  throws AppException{
		personaDao.actualizar(persona);
	}

}
