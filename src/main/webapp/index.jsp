
<%@ page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="container">
	<ul>
			<form action="Controller" method="post">
				<li>Ver todos los empleados <input type="submit" value="Mostrar" name="accion"></li>
			</form>
			<form action="Controller" method="POST">
				<li>Ver salario de un empleado especifico <input type="text" name="dni_salario"><input type="submit" value="SalarioEspecifico" name="accion"></li>
			</form>
			<form action="Controller" method="post">
				<li>Modificar empleado  
					<input type="text" name="dni">					
					<input type="submit" value="ModificarEmpleado" name="accion">
				</li>
			</form>
			<li>Añadir empleado<a href="AltaEmpleados.jsp"><button type="submit">Alta Empleado</button></a></li> 
		</ul>	
		
</div>
	
		

</body>
</html>