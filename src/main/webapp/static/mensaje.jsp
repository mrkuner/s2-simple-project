<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


		<br/><br/><br/>
		<logic:equal name="mensajeForm" property="textoRecordar" value="">
			<p class="mensajeError"><bean:write name="mensajeForm" property="texto" /></p>
			<p class="mensajeError"><html:link action="/volver.do" styleClass="linkError" tabindex="1">
				<img src="<html:rewrite page="/img/ico-verde.gif"/>" alt="Entrar en la aplicaci&oacute;n"/> Ir al menú
			</html:link>
			</p>
		</logic:equal>
		<logic:notEqual name="mensajeForm" property="textoRecordar" value="">
			<p class="mensajeError"><bean:write name="mensajeForm" property="textoRecordar" /></p>
			<p class="mensajeError"><html:link action="/home.do" styleClass="linkError" tabindex="1">
				<img src="<html:rewrite page="/img/ico-verde.gif"/>" alt="Ir a inicio"> Ir a inicio
			</html:link>
			</p>
		</logic:notEqual>

