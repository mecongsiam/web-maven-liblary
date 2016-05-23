<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Library</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
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
	<br>
	<c:set var="errorMessageLogPas" scope="session" value="${errorMessageLogPas }"/>
	<c:if test="${errorMessageLogPas eq true }"><c:out value="${message_error}" /></c:if>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
     

</body>
</html>