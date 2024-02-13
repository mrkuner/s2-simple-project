package com.farasanz.web.actions;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.farasanz.exceptions.AppException;
import com.opensymphony.xwork2.ActionSupport;



/**
 * Clase base para el resto de acciones de struts. Provee funcionalidades
 * basicas para las clases que las extiende
 */
public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variable que permite hacer log a todas las acciones que la exitenden
	 */
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Transforma una excepcion controla a mensajes disponibles en una jsp
	 * @param app La excepción controlada
	 * @param request una petición http
	 */
    public void excepcionAActionErrors(AppException app, HttpServletRequest request) {
        ArrayList<String> listaErrores = app.getErrores();
        for (String error : listaErrores) {
            addActionError(error);
        }
    }
	/**
	 * Permite mostrar un mensaje de exito tras hacer una operación correctamente y 
	 * lo hace disponible para una jsp
	 * @param request la petición http
	 */
    public void mensajeExito() {
        addActionMessage("mensajes.operacionExito");
    }
	
	/**
	 * Devuelve el fichero nombreFichero con el contenido del ByteArrayOutputStream baos.
	 * @param response
	 * @param nombreFichero
	 * @param baos
	 */
	protected void mostrarArchivo(HttpServletResponse response, String nombreFichero, ByteArrayOutputStream baos){
		// ponemos las cabeceras de la salida
		response.reset();
		response.resetBuffer();
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control",
				"must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setHeader("Content-disposition", "attachment; filename="
				+ nombreFichero);
		response.setContentType("application/pdf");

		// escribimos el fichero de la solicitud a la salida del servlet
		ServletOutputStream sos = null;

		try{
			sos = response.getOutputStream();
			baos.writeTo(sos);
			response.setContentLength(baos.size());
			sos.flush();
			sos.close();
			baos.close();
		} catch(Exception e){
				logger.error("excepcion " + e.getMessage());
		} finally{
			sos = null;
			baos = null;
		}
	}
	
}
