package com.farasanz.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.farasanz.dao.IPersonaDao;
import com.farasanz.exceptions.AppException;
import com.farasanz.model.Persona;

@Repository
public class PersonaDao extends SqlSessionDaoSupport implements IPersonaDao {

    protected static final Logger logger = LogManager.getLogger();
	
	public Persona obtener(Persona persona) throws AppException {
		Persona ret=null;
		try
		{
			
			ret=(Persona)getSqlSession().selectOne("Persona.obtenerPersona", persona);
			if (ret==null)
				throw new AppException("error_persona_no_encontrada");
		}
		catch (Exception ex)
		{
			logger.error(ex);
			throw new AppException("error_persona_no_encontrada");
		}
		return ret;
	}
	
	public void actualizar(Persona persona) throws AppException {
		try{
			this.getSqlSession().update("Persona.updatePersona", persona);
		}catch(Exception ex){
			logger.error(ex);
			throw new AppException("error_actualizando_persona");
		}
	}
}
