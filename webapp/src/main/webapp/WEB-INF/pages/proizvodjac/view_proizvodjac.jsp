<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Proizvodjac</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body class="bg-light">
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<div class='container'>
		<h3>Odabrani proizvodjac</h3>
		<form method='post' action='/webapp/application/proizvodjac/edit'>
			<div>
				<label for='pib'>PIB:</label> <br> <input type='text'
					name='pib' readonly="readonly" value='${proizvodjac.pib }'>
			</div>
			<div>
				<label for='maticniBroj'>Maticni broj:</label> <br> <input
					type='text' name='maticniBroj' readonly="readonly"
					value='${proizvodjac.maticniBroj }'>
			</div>
			<div>
				<label for='adresa'>Adresa:</label> <br> <input type='text'
					name='adresa' readonly="readonly" value='${proizvodjac.adresa }'>
			</div>
			<div>
				<label for='mesto'>Mesto:</label> <input type='text' name='mesto'
					readonly="readonly" value='${proizvodjac.mesto.naziv }'>
			</div>
			<input type='submit' value='Edit' name='btn-action'> <input
				type='submit' value='Back' name='btn-action'>
		</form>
		<div class='text-info'>${error}</div>
	</div>

</body>
</html>