<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<!-- Bootstrap -->
		<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<fmt:setLocale value="${sessionScope.local}" />
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
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/liblary/index.jsp">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav"></ul>

				</li>

			</ul>
			<form class="navbar-form navbar-left" role="search">

			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="create_user">Register</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${conf_button}<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><br/><form action="change_loc" method="post">
							<input type="hidden" name="command" value="en" /> <input
								type="submit" value="EN" class="btn btn-link"/>
						</form></li>
						<li><form action="change_loc" method="post">
							<input type="hidden" name="command" value="ru" /> <input
								type="submit" value="RU" class="btn btn-link"/><br />
						</form></li>

					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<%--<div class="container">--%>
	<%--<div class="row">--%>
		<%--<div class=""col-lg-3 col-md-3 col-sm-3></div>--%>
		<%--<div class=""col-lg-3 col-md-3 col-sm-3></div>--%>
		<%--<div class=""col-lg-3 col-md-3 col-sm-3></div>--%>
	<%--</div>--%>
<%--</div>--%>
<center>



	<br>

	<s:url value="/login" var="loginUrl" />
	<form name="loginForm" action="${loginUrl}" role="form" method="post">

		<input type="hidden" name="command" value="login" /><c:out value="${message_login }"/> : <br /> <input
			type="text" name="login" value=""class="input-group-lg" placeholder="enter login" /> <br /><c:out value="${message_password }"/> :<br /> <input
			type="password" name="password" value="" /><br /> <br>
			<input type="submit" value="${log_button }"  class="btn btn-default"  />


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
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>


</body>
</html>
