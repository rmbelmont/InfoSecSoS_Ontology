%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SECINFOSOS</title>
</head>
<body>
	<h1>SECINFOSOS</h1>
	
	
	
	<form action="<%=request.getContextPath()%>/processarFormulario2"
		method="get">
		<table style="with: 50%">
			<tr>
				<td>Procurar Algoritmo:</td>
				<td><input type="text" name="algoritmo" /></td>
			</tr>
			<tr>
		</table>
		<input type="submit" value="Buscar" />
	</form>
	<form action="<%=request.getContextPath()%>/ProcessaFormulario"
		method="get">

		<table>

			<tr>
				<td><label>Quais os fatores específicos são
						considerados no contexto de segurança da informação em SoS?</label></td>

			</tr>
			<tr>
				<td />
				<td><input type="submit" value="Buscar"
					style="width: 100%; border-radius: 5px;"></input></td>
			</tr>
		</table>
		
	</form>
</body>
</html>
