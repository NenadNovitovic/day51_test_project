<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> New Proizvodjac </title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<h1> Add new proizvodjac </h1>
	
	<form method='post' action='/webapp/application/proizvodjac/add'>
		<div>
			<label for='pib'>PIB:</label> <br>
			<input type='text' name='pib'>
		</div>
		<div>
			<label for='maticniBroj'>Maticni broj:</label> <br>
			<input type='text' name='maticniBroj'>
		</div>
		<div>
			<label for='adresa'>Adresa:</label> <br>
			<input type='text' name='adresa'>
		</div>
		<div>
			<label for='mesto'>Adresa:</label> <br>
			<select name="mesto">
				<c:forEach items="${mesta }" var= "mesto">
					<option value="${mesto.pttBroj }">${mesto.naziv } </option>
				</c:forEach>
			</select>
		</div>
		<input type='submit' value='Save proizvodjac'>
	</form>
	<div>${error}</div>
</body>
</html>