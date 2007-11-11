<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Meu Tempo - Lista Mestre</title>

<script type="text/css">
	body {
		margin-top: 0px;
	}

	h1 {
		text-color: red;
	}
</script>

</head>

<body>

<h1>Lista mestre de atividades </h1>

<s:iterator value="listaMestres">
	<h2><s:property value="id" /> <s:property value="descricao" /></h2> <br/>
</s:iterator>

</body>
</html>