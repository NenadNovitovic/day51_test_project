<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Mesto </title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	
	
	<form method='post' action='/webapp/application/mesto/edit'>
		<div>
			<label for='pttBroj'>PTT broj:</label> <br>
			<input type='text' name='pttBroj' value=${mesto.pttBroj} readonly="readonly">
		</div>
		<div>
			<label for='naziv'>Naziv:</label> <br>
			<input type='text' name='naziv' value=${mesto.naziv} readonly="readonly">
		</div>
		<input type='submit' name='btn-action' value='Edit'>
		<input type='submit' name='btn-action' value='Delete'>
		<input type='submit' name='btn-action' value='Back'>
	</form>
	<div>${error}</div>
</body>
</html>