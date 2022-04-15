<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Home page </title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	
	
	<form method='post' action='/webapp/application/mesto/add'>
		<div>
			<label for='pttBroj'>PTT broj:</label> <br>
			<input type='text' name='pttBroj'>
		</div>
		<div>
			<label for='naziv'>Naziv:</label> <br>
			<input type='text' name='naziv'>
		</div>
		<input type='submit' value='Sacuvaj mesto'>
	</form>
	<div>${error}</div>
</body>
</html>