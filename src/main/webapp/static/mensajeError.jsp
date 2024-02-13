<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


	<br/><br/><br/>
	<p  class="mensajeError">
		<bean:message key="error_global"/>
	</p>


	<p  class="mensajeError" >
		<html:link styleClass="linkError" action="/volver.do">
			<img src="<html:rewrite page="/img/ico-verde.gif"/>" alt="Entrar en la aplicaci&oacute;n"/>&nbsp;<bean:message key="volver_menu"/>
		</html:link>
	</p>
