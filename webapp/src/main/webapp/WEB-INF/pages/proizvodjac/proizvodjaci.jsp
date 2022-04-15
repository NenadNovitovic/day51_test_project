<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proizvodjaci</title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<h1>Svi uneseni proizvodjaci:</h1>
	<table>
		<thead>
			<tr>
				<td>PIB</td>
				<td>Maticni broj</td>
				<td>Adresa</td>
				<td>Naziv mesta</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ proizvodjaci }" var="proizvodjac">
				<tr>
					<td>${ proizvodjac.pib }</td>
					<td>${ proizvodjac.maticniBroj }</td>
					<td>${ proizvodjac.adresa }</td>
					<td>${ proizvodjac.mesto.naziv }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>${error}</div>
</body>
</html>