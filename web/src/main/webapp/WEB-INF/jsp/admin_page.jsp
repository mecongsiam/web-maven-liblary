<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Bootstrap -->
	<link href="css/bootstrap.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="admin.adminbutton.name.create_user"
	var="create_user" />
<fmt:message bundle="${loc}" key="admin.adminbutton.name.user_inf"
	var="user_inf" />
<fmt:message bundle="${loc}" key="admin.adminbutton.name.book_inf"
	var="book_inf" />

<fmt:message bundle="${loc}" key="admin.adminbutton.name.exit"
	var="exit" />
<fmt:message bundle="${loc}" key="local.locbutton.name.configuration"
	var="conf_button" />

</head>

<body>
<center>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="configuration" /> <input
			type="submit" value="${conf_button} ">

	</form>
	<br>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="create_user" /> <input
			type="submit" value="${create_user} ">
	</form>
	<br>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_users" /> <input
			type="submit" value="${user_inf} ">
	</form>
	<br>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_catalog" /> <input
			type="submit" value="${book_inf} ">
	</form>
	<br>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="exit" /> <input
			type="submit" value="${exit} ">
	</form>
</center>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>


</body>
</html>