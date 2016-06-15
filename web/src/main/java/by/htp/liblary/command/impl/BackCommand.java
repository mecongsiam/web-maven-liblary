package by.htp.liblary.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;

public class BackCommand implements Command {
	private static final String PREVIOUS_REQUEST = "previousRequest";
	private static final String PREVIOUS_PAGE = "previousPage";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		// TODO Auto-generated method stub

		/*if (request.getSession().getAttribute(PREVIOUS_REQUEST) != null) {
			try {
				response.sendRedirect(request.getSession().getAttribute(PREVIOUS_REQUEST).toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				request.getRequestDispatcher(request.getSession().getAttribute(PREVIOUS_PAGE).toString())
						.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		try {
			request.getRequestDispatcher(request.getSession().getAttribute(PREVIOUS_PAGE).toString())
                    .forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
