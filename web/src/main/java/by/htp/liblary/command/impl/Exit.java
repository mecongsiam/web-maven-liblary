package by.htp.liblary.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;
import by.htp.liblary.controller.PageName;

public class Exit implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		// TODO Auto-generated method stub

		request.getSession().invalidate();
		try {
			request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
