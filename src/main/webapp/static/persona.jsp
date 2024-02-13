<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.farasanz.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Register</title>
</head>
<body>
	<h3>Register for a prize by completing this form.</h3>

	<s:form action="procesarPersona">
		<s:textfield name="persona.tipoId" size="12" maxlength="1" tabindex="1" label="Tipo Id"/>
		<s:textfield name="persona.nombre" label="Nombre" tabindex="2"/>
		<s:textfield name="persona.apellido1" label="Primer Apellido" tabindex="3"/>
		<s:textfield name="persona.apellido2" label="Segundo Apellido" tabindex="4" />
		<s:textfield name="persona.sexo" size="12" maxlength="1" tabindex="6" label="Sexo"/>
		<s:textfield name="persona.fecha_nacimiento" size="12" maxlength="10" tabindex="7" label="Fecha Nacimiento"/>
		<s:submit cssClass="botones-submit" value="Guardar" name="guardar"
			class="boton" tabindex="8" />

		<s:hidden name="persona.id"></s:hidden>

	</s:form>
</body>
</html>