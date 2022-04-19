<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mesta!</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body class="bg-light">
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<div class='container'>
		<h1>Sva unesena mesta:</h1>
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>PTT broj</th>
					<th>Naziv</th>
					<th>View</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ mesta }" var="mesto">
					<tr>
						<td>${ mesto.pttBroj }</td>
						<td>${ mesto.naziv }</td>
						<td><a href="/webapp/application/mesto?ptt=${mesto.pttBroj}">
								View mesto</a></td>
						<td><a
							href="/webapp/application/mesto/delete?ptt=${mesto.pttBroj}">
								DELETE  </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class='text-info'>${error}</div>
	</div>

</body>
</html>