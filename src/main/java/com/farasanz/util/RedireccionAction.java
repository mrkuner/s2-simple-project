//package com.farasanz.util;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Action;
//
//import org.apache.struts2.ServletActionContext;
//import org.apache.struts2.convention.annotation.Namespace;
//import org.apache.struts2.convention.annotation.ParentPackage;
//
//import com.ejemplo.web.struts.actions.BaseAction;
//
//@Namespace("/")
//@ParentPackage("struts-default")
//public class RedireccionAction extends BaseAction {
//	public RedireccionAction() {}
//
////	/** 
////	 * Redirecciona a la p�gina de login cuando se supera el tiempo m�ximo de inactividad 
////	 * para que los lea la pantalla de descargas de las cartas.
////	 * @param mapping Clase ActionMapping del framework struts
////	 * @param form Clase ActionForm del framework struts
////	 * @param request la peticion http
////	 * @param response la respuesta http
////	 * @return clase del framework struts que representa el nombre l�gico del recurso al que se dirige la salida
////	 * @throws Exception si se produce un error inesperado.
////	 */
////	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
////		// esta accion s�lo sirve para poner los errores por timeout
////		ActionMessages aM = new ActionErrors();
////		aM.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error_login_timeout"));
////		saveErrors(request, aM);
////		return mapping.findForward(Constantes.EXITO_FORWARD);
////	}
//	
//	    @Action(value = "timeout")
//	    public String execute() {
//	        HttpServletRequest request = ServletActionContext.getRequest();
//	        HttpServletResponse response = ServletActionContext.getResponse();
//	        
//	        // Agregar un mensaje de error de timeout
//	        // Puedes hacerlo como mejor se adapte a tu l�gica de manejo de errores en Struts 2
//	        
//	        return "success"; // Devuelve el resultado l�gico de �xito
//	    }
//	}
//}