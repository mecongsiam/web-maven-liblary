<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Optional Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User page</title>
<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="admin.adminbutton.name.book_inf"
	var="book_inf" />

<fmt:message bundle="${loc}" key="admin.adminbutton.name.exit"
	var="exit" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.configuration"
	var="conf_button" />
</head>
<body>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="configuration" /> <input
			type="submit" value="${conf_button} ">

	</form>
	<br>
	<h1>Hello, user!</h1>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_catalog" /> <input
			type="submit" value="${book_inf} ">
	</form>
	<br>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="exit" /> <input
			type="submit" value="${exit} ">
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>