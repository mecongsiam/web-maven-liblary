package by.htp.liblary.command.impl;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.controller.PageName;
import by.htp.liblary.entity.User;
import by.htp.liblary.service.UserService;
import by.htp.liblary.service.exception.ServiceException;

public class LoginCommand implements Command {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String PREVIOUS_REQUEST = "previousRequest";
	private static final String PREVIOUS_PAGE = "previousPage";
	private static final String ERROR_MESSAGE_LOGPAS = "errorMessageLogPas";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PageName.INDEX_PAGE;
		String commandRes = "";
		String loginRes = "";
		String passwordRes = "";

		try {

			User user = UserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));

			if (user != null & user.getRole() != null) {
				request.getSession(true).setAttribute(LOGIN, user);

				if (user.getRole().equals("admin")) {
					page = PageName.ADMIN;
					request.getSession().removeAttribute(PREVIOUS_PAGE);
					

				} else {

					page = PageName.USER_PAGE;
					request.getSession(true).setAttribute(ERROR_MESSAGE_LOGPAS, false);
				}
			} else {

				request.setAttribute(ERROR_MESSAGE_LOGPAS, true);
				request.getSession(true).setAttribute(PREVIOUS_PAGE, PageName.INDEX_PAGE);

			}
		} catch (ServiceException e) {
			request.getSession(true).setAttribute(PREVIOUS_PAGE, PageName.INDEX_PAGE);

		}

		try {

			Map<String, String[]> params = request.getParameterMap();
			String[] temp;
			temp = params.get("command");

			for (String x : temp) {

				// System.out.println(x);
				commandRes = x;
			}
			temp = params.get("login");

			for (String x : temp) {

				// System.out.println(x);
				loginRes = x;
			}
			temp = params.get("password");

			for (String x : temp) {

				// System.out.println(x);
				passwordRes = x;
			}

			StringBuilder str = new StringBuilder();
			str.append(request.getRequestURL());
			str.append("?");
			str.append("command");
			str.append("=");
			str.append(commandRes);
			str.append("&");
			str.append("login");
			str.append("=");
			str.append(loginRes);
			str.append("&");
			str.append("password");
			str.append("=");
			str.append(passwordRes);

			request.getSession(true).setAttribute(PREVIOUS_REQUEST, str);

			request.getRequestDispatcher(page).forward(request, response);
			request.getSession(true).setAttribute(ERROR_MESSAGE_LOGPAS, false);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
