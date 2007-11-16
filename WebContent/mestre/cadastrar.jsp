<%@ taglib uri="/struts-tags" prefix="s" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Meu Tempo - Novo objetivo mestre</title>
</head>
<body>

<h2>Cadastrar objetivo mestre</h2>

<form method="post" action="<s:url action="cadastrar" namespace="/mestre"  includeParams="none" />">
<table>
	<tr>
		<td>Descrição:</td>
		<td><input type="text" name="mestre.descricao" size="70" /></td>
	</tr>
	<tr>
		<td>Tipo:</td>
		<td>
			<select name="mestre.prioridade.id">
				<option value="0">-- Selecione a prioridade --</option>
				<s:iterator value="prioridades">
					<option value="<s:property value="id" />"><s:property value="descricao" /></option>
				</s:iterator>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input class="button" type="submit" value="Cadastrar" />
			<input type="button" class="button" value="Cancelar" onclick="window.location = '<s:url action="listar" namespace="/mestre"  includeParams="none" />'" />
		</td>
	</tr>
</table>
</form>

</body>
</html>