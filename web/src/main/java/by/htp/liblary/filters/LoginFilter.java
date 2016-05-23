package by.htp.liblary.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import by.htp.liblary.controller.PageName;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	private static final String ERROR_MESSAGE_LOGPAS = "errorMessageLogPas";

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;

		if (!req.getParameter("login").equals("") & !req.getParameter("password").equals("")) {

			chain.doFilter(request, response);

		} else {
			req.getSession(true).setAttribute(ERROR_MESSAGE_LOGPAS, true);
			req.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			req.getSession(true).setAttribute(ERROR_MESSAGE_LOGPAS, false);

		}
		// pass the request along the filter chain

	}

	public void destroy() {

		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
