<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="includes/css/estilo.css" type="text/css" />
<title>Meu Tempo - Sistema de Administração do Tempo</title>
</head>
<body>

	<h1>Meu Tempo</h1>
	<h2>Sistema de Administração do Tempo</h2>

	<ul>
		<li><a href="<s:url action="listar" namespace="/mestre" includeParams="none" />" title="Objetivos Mestre">Listar Mestre</a></li>
	</ul>
	
	<%@include file="includes/rodape.jsp" %>
</body>
</html>