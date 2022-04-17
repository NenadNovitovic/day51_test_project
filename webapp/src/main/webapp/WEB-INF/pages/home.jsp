<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Home page </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body  class="bg-light">
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>
	<div class="p-3 container">
		<h1> Home PAGE</h1>
	</div>
</body>
</html>