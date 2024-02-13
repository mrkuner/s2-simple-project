<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>

<html xml:lang="es" lang="es" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><bean:message key="programa_titulo"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="verify-v1" content="/vj8XSi7jRH1ilVIo0I+weWECxS77hjWustQMQtGqqY=" />
<link rel="stylesheet" media="screen" type="text/css" href="/ejemplo/css/estilos-web-aplicaciones.css" />
<link rel="stylesheet" media="print" type="text/css" href="/ejemplo/css/estilos-web-imprimir-aplicaciones.css" />
<link rel="stylesheet" media="screen" type="text/css" href="/ejemplo/css/contenido-web-aplicaciones.css" />
<link rel="stylesheet" media="print" type="text/css" href="/ejemplo/css/contenido-web-imprimir-aplicaciones.css" />
<tiles:insert attribute="js1" ignore="true" />
<tiles:insert attribute="js2" ignore="true" />
</head>
<body>
<div id="cabecera-superior">	
	<div id="menu">
</div><!--fin menu-->
</div><!--fin cabecera-superior-->

<div id="contenedor">

<div id="seccion-politicasocial">



<h1>Ejemplo</h1>
</div>

<div id="contenido-ancho">

	<!-- <div class="enlaces">
		<ul>
			<li><a href="/ejemplo/contacto.html">Contacto</a></li>
		</ul>
	</div> -->

	<logic:messagesPresent message="false">
		<div class="error">
			<p>Errores:</p>
			<ul>
				<html:messages id="errores" message="false">
					<li>
						<bean:write name="errores" />
					</li>
				</html:messages>
			</ul>
		</div>
	</logic:messagesPresent>

	<logic:messagesPresent message="true">
		<div class="mensajes">
			<p>Atención:</p>
			<ul>
				<html:messages id="errores" message="true">
					<li>
						<bean:write name="errores" />
					</li>
				</html:messages>
			</ul>
		</div>
	</logic:messagesPresent>

	<tiles:importAttribute scope="request"/>
	<h2><bean:message key="${subtitulo}"/></h2>
	<div class="obligatorios"><strong>*</strong> Campos obligatorios</div>

	<tiles:insert attribute="contenido" />
</div>


<div id="pie">

</div>

</div></body></html>