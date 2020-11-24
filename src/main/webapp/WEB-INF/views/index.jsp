<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capstone 6 | Login</title>
</head>
<body>
	<h1>Capstone 6 - Tasks</h1>
	
	<h3>Login</h3>
	
	<form method="post" action="/login">
		Email: <input type="email" name="email" /><br />
		Password: <input type="password" name="password" /><br />
		<input type="submit" />
	</form>
	
	${ error }
	
	<h3>Register</h3>
	
	<form method="post" action="/register">
		Email: <input type="email" name="email" /><br />
		Password: <input type="password" name="password" /><br />
		<input type="submit" />
	</form>
	
	
</body>
</html>