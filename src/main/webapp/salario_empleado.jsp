<%@ page import = "laboral.*" %>
<%@ page import = "bbdd.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% if( (int)request.getAttribute("salario") > 0 ){	%>
			<p>El salario del empleado con dni <%= request.getAttribute("dni") %> es: <%= (int)request.getAttribute("salario") %></p>
		<%}else{
			throw new Exception();
		}%>
		
		<a href="index.jsp"><button type="submit">Pagina principal</button></a>
</body>
</html>