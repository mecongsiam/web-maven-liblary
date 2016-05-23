package by.htp.liblary.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import by.htp.liblary.regular_expression.Expression;
import by.htp.liblary.controller.PageName;

/**
 * Servlet Filter implementation class RegisterFilter
 */
public class RegisterFilter implements Filter {
	private String encoding;
	private ServletContext context;
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String EMAIL = "email";
	private static final String ADRESS = "address";
	private static final String PHONE = "phone";
	private static final String ROLE = "userRole";
	private static final String LOGIN_ERROR = "loginError";
	private static final String PASSWORD_ERROR = "passwordError";
	private static final String NAME_ERROR = "nameError";
	private static final String SURNAME_ERROR = "surnameError";
	private static final String EMAIL_ERROR = "emailError";
	private static final String ADDRESS_ERROR = "addressError";
	private static final String PHONE_ERROR = "phoneError";
	private static final String ROLE_ERROR = "roleError";
	private static final String LOGIN_DUALITY_ERROR = "loginDualityError";
	private static final String EMAIL_DUALITY_ERROR = "emailDualityError";
	private static final String RESULT_ADDUSER_MESSAGE = "resultAddUserMessage";
	private static final String REG_EMAIL_INVALID = "regEmailInvalid";
	private static final String REG_PHONE_INVALID = "regPhoneInvalid";
	private static final String REG_LOGIN_INVALID = "regLoginInvalid";
	private static final String REG_PASSWORD_INVALID = "regPasswordInvalid";
	private static final String REG_NAME_INVALID = "regNameInvalid";
	private static final String REG_SURNAME_INVALID = "regSurnameInvalid";
	private static final String REG_ADRESS_INVALID = "regAdressInvalid";

	/**
	 * Default constructor.
	 */
	public RegisterFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		boolean resultLogin = false;
		boolean resultPassword = false;
		boolean resultName = false;
		boolean resultSurname = false;
		boolean resultEmail = false;
		boolean resultAddress = false;
		boolean resultPhone = false;
		boolean resultUserRole = false;
		boolean resultEmailRegVal = false;
		boolean resultPhoneRegVal = false;
		boolean resultLoginRegVal = false;
		boolean resultPasswordRegVal = false;
		boolean resultNameRegVal = false;
		boolean resultSurnameRegVal = false;
		boolean resultAdressRegVal = false;

		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		context.log("Charset was set");
		req.getSession(true).setAttribute(LOGIN_ERROR, false);
		req.getSession(true).setAttribute(PASSWORD_ERROR, false);
		req.getSession(true).setAttribute(NAME_ERROR, false);
		req.getSession(true).setAttribute(SURNAME_ERROR, false);
		req.getSession(true).setAttribute(EMAIL_ERROR, false);
		req.getSession(true).setAttribute(ADDRESS_ERROR, false);
		req.getSession(true).setAttribute(PHONE_ERROR, false);
		req.getSession(true).setAttribute(ROLE_ERROR, false);
		req.getSession(true).setAttribute(EMAIL_DUALITY_ERROR, false);
		req.getSession(true).setAttribute(LOGIN_DUALITY_ERROR, false);
		req.getSession(true).setAttribute(RESULT_ADDUSER_MESSAGE, false);
		req.getSession(true).setAttribute(REG_EMAIL_INVALID, false);
		req.getSession(true).setAttribute(REG_PHONE_INVALID, false);
		req.getSession(true).setAttribute(REG_LOGIN_INVALID, false);
		req.getSession(true).setAttribute(REG_PASSWORD_INVALID, false);
		req.getSession(true).setAttribute(REG_NAME_INVALID, false);
		req.getSession(true).setAttribute(REG_SURNAME_INVALID, false);
		req.getSession(true).setAttribute(REG_ADRESS_INVALID, false);

		resultLogin = req.getParameter(LOGIN).isEmpty();
		resultPassword = req.getParameter(PASSWORD).isEmpty();
		resultName = req.getParameter(NAME).isEmpty();
		resultSurname = req.getParameter(SURNAME).isEmpty();
		resultEmail = req.getParameter(EMAIL).isEmpty();
		resultAddress = req.getParameter(ADRESS).isEmpty();
		resultPhone = req.getParameter(PHONE).isEmpty();
		resultUserRole = req.getParameter(ROLE).isEmpty();
		resultEmailRegVal = Expression.emailValidation(req.getParameter(EMAIL));
		resultPhoneRegVal = Expression.phoneValidation(req.getParameter(PHONE));
		resultLoginRegVal = Expression.loginValidation(req.getParameter(LOGIN));
		resultPasswordRegVal = Expression.passwordValidation(req.getParameter(PASSWORD));
		resultNameRegVal = Expression.nameValidation(req.getParameter(NAME));
		resultSurnameRegVal = Expression.surnameValidation(req.getParameter(SURNAME));
		resultAdressRegVal = Expression.adressValidation(req.getParameter(ADRESS));

		if (resultLogin) {
			req.getSession(true).setAttribute(LOGIN_ERROR, true);
		}
		if (resultPassword) {
			req.getSession(true).setAttribute(PASSWORD_ERROR, true);
		}
		if (resultName) {
			req.getSession(true).setAttribute(NAME_ERROR, true);
		}
		if (resultSurname) {
			req.getSession(true).setAttribute(SURNAME_ERROR, true);
		}
		if (resultEmail) {
			req.getSession(true).setAttribute(EMAIL_ERROR, true);
		}
		if (resultAddress) {
			req.getSession(true).setAttribute(ADDRESS_ERROR, true);
		}
		if (resultPhone) {
			req.getSession(true).setAttribute(PHONE_ERROR, true);
		}
		if (resultUserRole) {
			req.getSession(true).setAttribute(ROLE_ERROR, true);

		}
		if (resultEmailRegVal) {
			req.getSession(true).setAttribute(REG_EMAIL_INVALID, true);
		}
		if (resultPhoneRegVal) {
			req.getSession(true).setAttribute(REG_PHONE_INVALID, true);
		}
		if (resultLoginRegVal) {
			req.getSession(true).setAttribute(REG_LOGIN_INVALID, true);
		}
		if (resultPasswordRegVal) {
			req.getSession(true).setAttribute(REG_PASSWORD_INVALID, true);
		}
		if (resultNameRegVal) {
			req.getSession(true).setAttribute(REG_NAME_INVALID, true);
		}
		if (resultSurnameRegVal) {
			req.getSession(true).setAttribute(REG_SURNAME_INVALID, true);
		}
		if (resultAdressRegVal) {
			req.getSession(true).setAttribute(REG_ADRESS_INVALID, true);
		}

		if (!resultLogin & !resultPassword & !resultName & !resultSurname & !resultEmail & !resultAddress & !resultPhone
				& !resultUserRole & !resultEmailRegVal & !resultPhoneRegVal&!resultLoginRegVal
				&!resultPasswordRegVal&!resultNameRegVal&!resultSurnameRegVal&!resultAdressRegVal) {
			chain.doFilter(request, response);

		} else {

			req.getRequestDispatcher(PageName.REGISTER).forward(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = fConfig.getInitParameter("characterEncoding");
		context = fConfig.getServletContext();

	}

}
