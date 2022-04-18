<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New mesto</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body  class="bg-light">
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>

	<div class="container">
		<h2>Dodajte novo mesto</h2>
		<form method='post' action='/webapp/application/mesto/add'>
			<div class="form-group">
				<label for='pttBroj'>PTT broj:</label> <br> <input type='text'
					name='pttBroj'>
			</div>
			<div class="form-group">
				<label for='naziv'>Naziv:</label> <br> <input type='text'
					name='naziv'>
			</div>
			<input type='submit' value='Sacuvaj mesto'>
		</form>
		<div>${error}</div>
	</div>

</body>
</html>