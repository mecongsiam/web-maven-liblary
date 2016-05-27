<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<!-- Bootstrap -->
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message.password"
	var="message_password" />
<fmt:message bundle="${loc}" key="local.message.login"
	var="message_login" />
<fmt:message bundle="${loc}" key="local.locbutton.name.login"
	var="log_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.configuration"
	var="conf_button" />
<fmt:message bundle="${loc}" key="local.message.error"
	var="message_error" />	


</head>

<body>
<div class="container">
	<div class="row">
		<div class=""col-lg-3 col-md-3 col-sm-3></div>
		<div class=""col-lg-3 col-md-3 col-sm-3></div>
		<div class=""col-lg-3 col-md-3 col-sm-3></div>
	</div>
</div>
<center>


	<form action="Controller" method="post">
	
	<input type="hidden" name="command" value="configuration" />
		<input type="submit" value="${conf_button} ">
		
	</form>
	<br>
	<form action="login" method="post">

		<input type="hidden" name="command" value="login" /><c:out value="${message_login }"/> : <br /> <input
			type="text" name="login" value="" /> <br /><c:out value="${message_password }"/> :<br /> <input
			type="password" name="password" value="" /><br /> <br>
			<input type="submit" value="${log_button }" />
			
			
	</form>
</center>
	<br>
<center>
	<c:set var="errorMessageLogPas" scope="session" value="${errorMessageLogPas }"/>
	<c:if test="${errorMessageLogPas eq true }"><c:out value="${message_error}" /></c:if>
</center>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>


</body>
</html>