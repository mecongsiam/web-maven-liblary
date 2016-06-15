<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>Hello</title>

	<!-- Bootstrap -->
	<link href="css/bootstrap.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<c:set var="num_of_user" scope="session" />
</head>
<body>

	<jsp:useBean id="userbean" class="by.htp.liblary.jsp_bean.JSPUserBean" scope="request"/>
	<mytag:jsparr jspUserBean="${userbean }"/>
	<mytag:pagin jspUserBean="${userbean}"/>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="change_interval" />
		<select name="userInterval">
			<option value="3">3</option>
			<option value="5">5</option>	</select>  <br /> <input
			type="submit" value="Interval" />
	</form>


	<form action="Controller" method="post">

		<input type="hidden" name="command" value="back" /> <input
			type="submit" value="back">

	</form>

		<br/>

		<br>
	</center>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>