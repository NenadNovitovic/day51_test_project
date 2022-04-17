<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Index page </title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body class="bg-light">
	
	<div class="p-3 border-bottom container  centered-div">
	<h1> Welcome, please login </h1>
		<form method='post' action='/webapp/application/login'>
		<div>
			<label for='username'>Username:</label> <br>
			<input value='admin' type='text' name='username'>
		</div>
		<div>
			<label for='password'>Password:</label> <br>
			<input value='admin' type='password' name='password'>
		</div>
		<input type='submit' value='Login'>
	</form>
	<div class='text-info'>${error}</div>
	</div>

</body>
</html>