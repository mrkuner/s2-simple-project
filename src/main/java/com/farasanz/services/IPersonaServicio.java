package com.farasanz.services;

import com.farasanz.exceptions.AppException;
import com.farasanz.model.Persona;

public interface IPersonaServicio {

	public Persona obtener(Persona persona) throws AppException;	
	
	public void actualizar(Persona persona) throws AppException;
	
}
