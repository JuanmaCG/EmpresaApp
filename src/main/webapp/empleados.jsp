<%@ page import = "bbdd.*" import="java.util.List" import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 	List<String> empleados = (ArrayList<String>)request.getAttribute("empleados");
		String[] datos;%>
		
	<table border="1px solid black">
		<tr>
			<td>Nombre: </td>
			<td>DNI: </td>
			<td>Sexo: </td>
			<td>Categoria: </td>
			<td>Años: </td>
		</tr>
		<% for(int i = 0; i < empleados.size(); i++){ %>
			<tr>
				<%for(int j = 0; j < 5; j++){ 
					datos = empleados.get(i).split(",");
				%>
		 			<td><%= datos[j] %> </td>
			<% }  
			}%>
		
		
		
	</table>
	
	<a href="index.jsp"><button type="submit">Pagina principal</button></a>
</body>
</html>