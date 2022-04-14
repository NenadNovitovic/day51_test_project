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
	<h1> Welcome, to our app ${ user.name }!  </h1>
	
	<a href="/webapp/application/mesto/add">Dodaj novo mesto</a>
	<a href="/webapp/application/mesta">Vidi sva mesta</a>
	
	<a href="/webapp/application/proizvodjac/add">Dodaj novog proizvodjaca</a>
	<a href="/webapp/application/proizvodjac/proizvodjaci">Dodaj novog proizvodjaca</a>
</body>
</html>