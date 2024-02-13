package com.farasanz.dao;

import com.farasanz.exceptions.AppException;
import com.farasanz.model.Persona;


public interface IPersonaDao {

	public Persona obtener(Persona persona) throws AppException;
		
	public void actualizar(Persona persona) throws AppException;
	
}
