<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="true" %>
<c:url value="/controller" var="linkServletController"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/cellrocket/controller" method="post">
		Login: <input type="text" name="login">
		Senha: <input type="text" name="senha">
		
		<input type="hidden" name="acao" value="Login">
		
		<input type="submit" value="Logar">
	</form>
	
</body>
</html>