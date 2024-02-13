package com.farasanz.web.actions;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class DescagarFicheroBaseAction extends BaseAction {
	/**
	 * Prepara la salida de la accion para mostrar contenido binario (un fichero). 
	 * @param response Respuesta http
	 * @param nombreFichero Nombre del fichero con el que se va a realizar la descarga
	 * @param mimeType Tipo mime del fichero a descargar
	 * @param contenidoFichero contenido del stream del fichero
	 */
	protected void mostrarFichero(HttpServletResponse response,
			                      String nombreFichero ,
			                      String mimeType,
			                      byte[] contenidoFichero 
			) throws Exception{
		
		// pone las cabeceras necesarias para la salida de los ficheros.
	    response.reset();
	    response.resetBuffer();
	    response.setHeader("Expires", "0");
	    response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
	    response.setHeader("Pragma", "public");
	    response.setHeader("Content-disposition",
	                        "attachment; filename=" + nombreFichero );
	    response.setContentType( mimeType );
	    
	    // escribimos la salida
	    try{
	    	OutputStream os =response.getOutputStream();
	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	baos.write(contenidoFichero);
	    	baos.writeTo(os);
	    	baos.close();
            os.close();
	    } catch(Exception e){
	    	logger.error("Error en descargarFicheroBaseAction " + e.getMessage() );
	    	throw e;
	    }
	}
}
