<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Index page </title>
</head>
<body>
	<h1> Welcome, please login </h1>
	<form method='post' action='/webapp/application/login'>
		<div>
			<label for='username'>Username:</label> <br>
			<input type='text' name='username'>
		</div>
		<div>
			<label for='password'>Password:</label> <br>
			<input type='password' name='password'>
		</div>
		<input type='submit' value='Login'>
	</form>
	<div>${error_user_not_found }</div>
</body>
</html>