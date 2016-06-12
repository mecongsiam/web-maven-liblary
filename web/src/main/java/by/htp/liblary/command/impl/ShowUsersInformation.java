package by.htp.liblary.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;
import by.htp.liblary.controller.PageName;
import by.htp.liblary.entity.Abonement;
import by.htp.liblary.entity.User;
import by.htp.liblary.jsp_bean.JSPUserBean;
import by.htp.liblary.service.UserService;
import by.htp.liblary.service.exception.ServiceException;

public class ShowUsersInformation implements Command {
	private static final String USERBEAN = "userbean";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		// TODO Auto-generated method stub


		List<User> arr;
		try {
			arr = UserService.showUsers();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			throw new CommandException(e.getMessage(),e);
		}
		JSPUserBean jsp = new JSPUserBean(arr);
		request.setAttribute(USERBEAN, jsp);

		try {
			request.getRequestDispatcher(PageName.SHOW_USERS).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			throw new CommandException(e.getMessage(),e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CommandException(e.getMessage(),e);
		}
	}

}
