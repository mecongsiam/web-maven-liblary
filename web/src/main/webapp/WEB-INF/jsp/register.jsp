<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<fmt:message bundle="${loc}" key="local.message.password"
	var="message_password" />
<fmt:message bundle="${loc}" key="local.message.password.error"
	var="message_password_error" />
<fmt:message bundle="${loc}" key="local.message.password.errorRegVal"
	var="message_password_error_reg_val" />
<fmt:message bundle="${loc}" key="local.message.login"
	var="message_login" />
<fmt:message bundle="${loc}" key="local.message.login.error"
	var="message_login_error" />
<fmt:message bundle="${loc}" key="local.message.login.errorduality"
	var="message_login_error_duality" />
<fmt:message bundle="${loc}" key="local.message.login.errorRegVal"
	var="message_login_error_reg_Val" />
<fmt:message bundle="${loc}" key="register.message.name"
	var="message_name" />
<fmt:message bundle="${loc}" key="register.message.name.error"
	var="message_name_error" />
<fmt:message bundle="${loc}" key="register.message.name.errorRegVal"
	var="message_name_error_reg_val" />
<fmt:message bundle="${loc}" key="register.message.surname"
	var="message_surname" />
<fmt:message bundle="${loc}" key="register.message.surname.error"
	var="message_surname_error" />
<fmt:message bundle="${loc}" key="register.message.surname.errorRegVal"
	var="message_surname_error_reg_val" />
<fmt:message bundle="${loc}" key="register.message.email"
	var="message_email" />
<fmt:message bundle="${loc}" key="register.message.email.error"
	var="message_email_error" />
<fmt:message bundle="${loc}" key="register.message.email.reginvalid"
	var="message_email_reginvalid" />
<fmt:message bundle="${loc}" key="reqister.message.email.errorduality"
	var="message_email_error_duality" />
<fmt:message bundle="${loc}" key="register.message.address"
	var="message_address" />
<fmt:message bundle="${loc}" key="register.message.address.error"
	var="message_address_error" />
<fmt:message bundle="${loc}" key="register.message.address.errorRegVal"
	var="message_address_error_reg_val" />
<fmt:message bundle="${loc}" key="register.message.phone"
	var="message_phone" />
<fmt:message bundle="${loc}" key="register.message.phone.error"
	var="message_phone_error" />
<fmt:message bundle="${loc}" key="register.message.phone.reginvalid"
	var="message_phone_reginvalid" />
<fmt:message bundle="${loc}" key="register.message.role"
	var="message_role" />
<fmt:message bundle="${loc}" key="register.message.role.error"
	var="message_role_error" />
<fmt:message bundle="${loc}" key="register.recbutton.name.submit"
	var="sub_button" />
<fmt:message bundle="${loc}" key="register.user.created"
	var="user_created" />
<fmt:message bundle="${loc}" key="local.locbutton.name.configuration"
	var="conf_button" />
<c:set var="loginError" scope="session" value="${loginError }" />
<c:set var="passwordError" scope="session" value="${passwordError }" />
<c:set var="nameError" scope="session" value="${nameError }" />
<c:set var="surnameError" scope="session" value="${surnameError }" />
<c:set var="emailError" scope="session" value="${emailError }" />
<c:set var="phoneError" scope="session" value="${phoneError }" />
<c:set var="roleError" scope="session" value="${roleError }" />
<c:set var="loginDualityError" scope="session"
	value="${loginDualityError }" />
<c:set var="emailDualityError" scope="session"
	value="${emailDualityError }" />
<c:set var="resultAddUserMessage" scope="session"
	value="${resultAddUserMessage }" />
<c:set var="regEmailInvalid" scope="session" value="${regEmailInvalid }" />
<c:set var="regPhoneInvalid" scope="session" value="${regPhoneInvalid }" />
<c:set var="regLoginInvalid" scope="session" value="${regLoginInvalid }" />
<c:set var="regPasswordInvalid" scope="session" value="${regPasswordInvalid }" />
<c:set var="regNameInvalid" scope="session" value="${regNameInvalid }" />
<c:set var="regSurnameInvalid" scope="session" value="${regSurnameInvalid }" />
<c:set var="regAdressInvalid" scope="session" value="${regAdressInvalid }" />

</head>

<body>
	<form action="Controller" method="post">

		<input type="hidden" name="command" value="configuration" /> <input
			type="submit" value="${conf_button} ">

	</form>
	<center>
	<form action="register" method="post">

		<input type="hidden" name="command" value="register_user" />
		<c:out value="${message_login }" />
		: <br /> <input type="text" name="login" value="" /> <br />

		<c:out value="${message_password }" />
		:<br /> <input type="password" name="password" value="" /><br />


		<c:out value="${message_name }" />
		: <br /> <input type="text" name="name" value="" /> <br />


		<c:out value="${message_surname }" />
		: <br /> <input type="text" name="surname" value="" /> <br />


		<c:out value="${message_email }" />
		: <br /> <input type="text" name="email" value="" /> <br />


		<c:out value="${message_address }" />
		: <br /> <input type="text" name="address" value="" /> <br />


		<c:out value="${message_phone }" />
		: <br /> <input type="text" name="phone" value="" /> <br />


		<c:out value="${message_role }" />
		: <br />	<select name="userRole">
			<option value="admin">admin</option>
			<option value="user">user</option>	</select>  <br /> <input
			type="submit" value="${sub_button }" /> 
			


	</form>
	<br>
	<form action="Controller" method="post">

		<input type="hidden" name="command" value="back" /> <input
			type="submit" value="back">

	</form>
	</center>

	<c:if test="${loginError eq true }">
		<c:out value="${message_login_error }" />
	</c:if>
	<c:if test="${loginDualityError eq true }">
		<c:out value="${message_login_error_duality }" />
	</c:if>
	<c:if test="${passwordError eq true }">
		<c:out value="${message_password_error }" />
	</c:if>
	<c:if test="${nameError eq true }">
		<c:out value="${message_name_error }" />
	</c:if>
	<c:if test="${surnameError eq true }">
		<c:out value="${message_surname_error }" />
	</c:if>
	<c:if test="${emailError eq true }">
		<c:out value="${message_email_error }" />
	</c:if>
	<c:if test="${emailDualityError eq true }">
		<c:out value="${message_email_error_duality }" />
	</c:if>
	<c:if test="${phoneError eq true }">
		<c:out value="${message_phone_error }" />
	</c:if>
	<c:if test="${roleError eq true }">
		<c:out value="${message_role_error }" />
	</c:if>
	<c:if test="${resultAddUserMessage eq true }">
		<c:out value="${user_created }" />
	</c:if>
	<c:if test="${regEmailInvalid eq true }">
		<c:out value="${message_email_reginvalid }" />
	</c:if>
	<c:if test="${regPhoneInvalid eq true }">
		<c:out value="${message_phone_reginvalid }" />
	</c:if>
	<c:if test="${regLoginInvalid eq true }">
		<c:out value="${message_login_error_reg_Val }" />
	</c:if>
	<c:if test="${regPasswordInvalid eq true }">
		<c:out value="${message_password_error_reg_val }" />
	</c:if>
	<c:if test="${regNameInvalid eq true }">
		<c:out value="Not Correct Name" />
	</c:if>
	<c:if test="${regSurnameInvalid eq true }">
		<c:out value="Not Correct Surname" />
	</c:if>
	<c:if test="${regAdressInvalid eq true }">
		<c:out value="Not Correct Adress" />
	</c:if>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>

</body>
</html>