<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<h1>Input your information:</h1>
	<form action="<%=request.getContextPath()%>/ProcessaFormulario"
		method="get">

		<table>

			<tr>
				<td><label>Quais os fatores específicos são considerados 
				no contexto de segurança da informação em SoS?</label></td>
				
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
