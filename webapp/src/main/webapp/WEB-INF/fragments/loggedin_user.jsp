<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<div class='container'>
	<h2 class='bg-light text-dark'> Welcome, to our app ${ sessionScope.user.name }! <a class='float-right' href='/webapp/application/logout'> logout!</a></h2>
</div>

	