<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Error page</title>
</head>
<body>
	<c:set var="errorException" scope="session"
		value="${exceptionMessage }" />
	<c:out value="${errorException }" />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="exit" /> <input
			type="submit" value="ok ">
	</form>
</body>
</html>