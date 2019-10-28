<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="Controller" method="POST">
		Nombre: <input type="text" name="nombre"><br>
		DNI: <input type="text" name="dni"><br>
		Sexo: <input type="text" name="sexo"><br>
		Categoria: <input type="text" name="categoria"><br>
		Anyos: <input type="text" name="anyos"><br>
		
		<input type="submit" value="DarDeAlta" name="accion" >
	</form>
	<br><a href="index.jsp"><button type="submit">Pagina principal</button></a>
</body>
</html>