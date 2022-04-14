<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> New Proizvodjac </title>
</head>
<body>
	<h1> Add new proizvodjac </h1>
	
	<form method='post' action='/webapp/application/login'>
		<div>
			<label for='pib'>PIB:</label> <br>
			<input type='text' name='pib'>
		</div>
		<div>
			<label for='maticniBroj'>Maticni broj:</label> <br>
			<input type='password' name='maticniBroj'>
		</div>
		<div>
			<label for='adresa'>Adresa:</label> <br>
			<input type='password' name='adresa'>
		</div>
		<div>
			<label for='mesto'>Adresa:</label> <br>
			<input type='password' name='mesto'>
			mada ovde treba da bude select
		</div>
		<input type='submit' value='Login'>
	</form>
	<div>${error}</div>
</body>
</html>