<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mesta!</title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<h1>Sva unesena mesta:</h1>
	<table>
		<thead>
			<tr>
				<td>PTT broj</td>
				<td>Naziv</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ mesta }" var="mesto">
				<tr>
					<td>${ mesto.pttBroj }</td>
					<td>${ mesto.naziv }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>${error}</div>
</body>
</html>