package com.farasanz.web.actions;

import java.security.InvalidParameterException;

import org.apache.struts2.ServletActionContext;

import com.farasanz.exceptions.AppException;
import com.farasanz.util.Constantes;
import com.farasanz.web.forms.BaseValidatorActionForm;

public class BaseOperacionAction  extends BaseAction {
	private static final long serialVersionUID = 6668836601359416L;

	/*
	 * Esta accion representa un formulario encargado de hacer inserciones,
	 * modificaciones y borrados. Se necesita que la operacion a ejecutar llege
	 * en un parametro (o campo) del formulario llamado operacion. Dependiendo
	 * de los valores de este parametro, se hará una inserción, una modificación
	 * o un borrado.
	 * 
	 * Por defecto, no se permitirá ninguna de esas tres operaciones, lanzandose
	 * una exception, siendo por tanto obligatorio sobreescribir alguno de los
	 * métodos hacerInsercion, hacerBorrado o hacerModificación.
	 * 
	 * Cuando se sobreescribe este tipo de acción, no se debe sobreescribir el
	 * metodo execute.
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	 @Override
	    public String execute() throws Exception {
	        String siguienteRecurso = "";
	        BaseValidatorActionForm baseForm = (BaseValidatorActionForm) ServletActionContext.getRequest().getAttribute("baseValidatorActionForm");

	        String operacion = baseForm.getOperacion();

	        try {
	            if (operacion.equals(Constantes.OPERACION_INSERTAR)) {
	                hacerInsercion(baseForm);
	                baseForm.setOperacion(Constantes.OPERACION_ACTUALIZAR);
	            } else if (operacion.equals(Constantes.OPERACION_ACTUALIZAR)) {
	                hacerModificacion(baseForm);
	            } else if (operacion.equals(Constantes.OPERACION_ELIMINAR)) {
	                hacerBorrado(baseForm);
	            } else {
	                throw new InvalidParameterException();
	            }

	            mensajeExito();
	            siguienteRecurso = Constantes.EXITO_FORWARD;
	        } catch (AppException app) {
	            excepcionAActionErrors(app, ServletActionContext.getRequest());
	            siguienteRecurso = Constantes.ERROR_FORWARD;
	        }

	        return siguienteRecurso;
	    }
	
	
	    private void hacerInsercion(BaseValidatorActionForm baseForm) throws AppException {
	        // Lógica de inserción
	    }

	    private void hacerModificacion(BaseValidatorActionForm baseForm) throws AppException {
	        // Lógica de modificación
	    }

	    private void hacerBorrado(BaseValidatorActionForm baseForm) throws AppException {
	        // Lógica de borrado
	    }

}
