<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../includes/css/estilo.css" type="text/css" /> 
<title>Meu Tempo - Lista Mestre</title>
</head>

<body>

	<h1>Lista Mestre de atividades </h1>
	
	<ul>
		<li><a href="<s:url action="novo" namespace="/mestre" includeParams="none" />" title="Novo mestre">Novo</a></li>
	</ul>
	
	<s:actionerror/>
	<s:actionmessage/>
	
	<s:iterator value="listaMestres">
		<h2><s:property value="descricao" /></h2> <br/>
		<s:property value="prioridade.descricao" /> <br/>
		<p><s:property value="dataInclusao" /> <br/>
		Concluído: <s:property value="concluido" /></p>
	</s:iterator>
	
	<%@include file="../includes/rodape.jsp" %>

</body>
</html>