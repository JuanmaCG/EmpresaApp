<%@page import="laboral.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Empleado emp = (Empleado)request.getAttribute("empleado"); %>
	<form action="Controller" method="post">
		Nombre: <input type="text" value="<%= emp.nombre %>" name="nombre" ><br>
		Dni: <input type="text" value="<%=emp.dni %>" name="dni" readOnly><br>
		Sexo: <input type="text" value="<%=emp.sexo %>" name="sexo"><br>
		Categoria: <input type="number" value="<%=emp.getCategoria() %>" name="categoria"><br>
		Anyos: <input type="number" value="<%=emp.anyos %>" name="anyos">
		<input type="submit" value="Modificar" name="accion">
	</form>

	<br><a href="index.jsp"><button type="submit">Pagina principal</button></a>
	
</body>
</html>