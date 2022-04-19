<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proizvodjaci</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head  class="bg-light">
<body>
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<div class='container'>
		<h1>Svi uneseni proizvodjaci:</h1>
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">PIB</th>
					<th scope="col">Maticni broj</th>
					<th scope="col">Adresa</th>
					<th scope="col">Naziv mesta</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ proizvodjaci }" var="proizvodjac">
					<tr scope="row">
						<td>${ proizvodjac.pib }</td>
						<td>${ proizvodjac.maticniBroj }</td>
						<td>${ proizvodjac.adresa }</td>
						<td>${ proizvodjac.mesto.naziv }</td>		
						<td><a href="/webapp/application/proizvodjac/delete?pib=${proizvodjac.pib}">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>${error}</div>
	</div>

</body>
</html>