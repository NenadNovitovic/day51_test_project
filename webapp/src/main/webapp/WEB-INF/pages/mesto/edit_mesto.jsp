<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Mesto</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body  class="bg-light">
	<jsp:include page="/WEB-INF/fragments/loggedin_user.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>


	<div class="container">
		<h2>Izmenite mesto :</h2>
		<form method='post' action='/webapp/application/mesto/edit'>
			<div>
				<label for='pttBroj'>PTT broj:</label> <br> <input type='text'
					name='pttBroj' value=${mesto.pttBroj } readonly="readonly">
			</div>
			<div>
				<label for='naziv'>Naziv:</label> <br> <input type='text'
					name='naziv' value='${mesto.naziv}'>
			</div>
			<input type='submit' name='btn-action' value='Edit'> <input
				type='submit' name='btn-action' value='Back'>
		</form>
		<div>${error}</div>
	</div>
</body>
</html>