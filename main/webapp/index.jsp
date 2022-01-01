<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="ServletLogando" method="post">
		
	
		
		<input name="login" type="text">
		<input name="senha" type="password">
		
		<input type="submit" value="entrar">
		
	</form>
	
	<h4>${msg}</h4>
	
</body>
</html>