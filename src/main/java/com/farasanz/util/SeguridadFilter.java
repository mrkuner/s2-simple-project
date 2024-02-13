package com.farasanz.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.farasanz.exceptions.AppException;



/**
 * Implementa la comprobaci�n de acceso a recursos
 */
public class SeguridadFilter implements Filter{
	/**
	 * Variable de configuraci�n del filtro
	 */
	private FilterConfig _filterConfig = null;

	/**
	 * Variable que permite hacer log
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * P�gina de login a la que se pueden hacer las redirecciones
	 */
	String paginaLogin = null;

	/**
	 * Inicializa el filtro
	 * @param filterConfig permite inicializar la configuraci�n del filtro
	 * @throws ServletException si se produce un error no controlado
	 */
	public void init(FilterConfig filterConfig) throws ServletException{
		_filterConfig = filterConfig;
		paginaLogin = filterConfig.getInitParameter("pagina-login");
		//logger.debug("pagina-login " + paginaLogin);
	}

	/**
	 * Libera los recursos del filtro.
	 */
	public void destroy(){
		_filterConfig = null;
	}

	/**
	 * Comprueba si la petici�n corresponde a un usuario registrado o bien es un intento de acceso no autorizado, en
	 * cuyo caso reenviar� a la p�gina de login.
	 * @param request petici�n del serlvet que filtra
	 * @param response resupesta del servlet que filtra
	 * @param chain variable que permite la redirecci�n a recursos
	 * @throws IOException si se produce un error de lectura/escritura
	 * @throws ServletException si se produce un error no controlado
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		//logger.debug("en SeguridadFilter.doFilter()");

		HttpSession objHttpSession = null;
		HttpServletRequest objHttpRequest = null;
		HttpServletResponse objHttpResponse = null;
		SesionBean sesBean = null;

		if (request instanceof HttpServletRequest){
			objHttpRequest = (HttpServletRequest) request;
			objHttpSession = objHttpRequest.getSession();
			sesBean = (SesionBean) objHttpSession.getAttribute(Constantes.SESION_BEAN);
		}

		if (response instanceof HttpServletResponse){
			 objHttpResponse = (HttpServletResponse) response;
		}

		try{
			if (sesBean == null){
				throw new AppException("error recogiendo los datos del usuario de la sesion 1");
			}
			chain.doFilter(request, response);
			/*else{
				logger.debug("todo ok");
			}*/
		}
		catch(AppException e){
			logger.error("---------------------------------------");
			logger.error("Error en seguridad filter");
			logger.error(e.toString());
			logger.error(e.getMessage());
			logger.error("---------------------------------------");
			objHttpSession.invalidate();
			logger.error("Se super� el timeOut");
			String pathApp = objHttpRequest.getContextPath();
			if (! pathApp.endsWith("/")){
				pathApp = pathApp + "/";
			}
			pathApp = pathApp + "timeout.do";
			logger.debug("Redireccionamos a :"+pathApp);
			objHttpResponse.sendRedirect(pathApp);
		}
	}
}