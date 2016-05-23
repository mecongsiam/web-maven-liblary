package by.htp.liblary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.CommandHelper;
import by.htp.liblary.command.exception.CommandException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String COMMAND_NAME = "command";
	private static final String EXCEPTION_MESSAGE="exceptionMessage";
	//private static final Logger LOG=LogManager.getLogger("by.htp.liblary.listeners");
	

	private final CommandHelper commandHelper = new CommandHelper();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;

		try {
			
			commandName = request.getParameter(COMMAND_NAME);
			command = commandHelper.getCommand(commandName);
			command.execute(request, response);

		} catch (CommandException e) {
			// logging
			//LOG.error(e.getMessage());
			request.setAttribute(EXCEPTION_MESSAGE, e.getMessage());
			request.getSession().invalidate();
			request.getRequestDispatcher(PageName.ERROR_PAGE).forward(request, response);

		}

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;

		try {
			
			commandName = request.getParameter(COMMAND_NAME);
			command = commandHelper.getCommand(commandName);
			command.execute(request, response);

		} catch (CommandException e) {
			// logging
			//LOG.error(e.getMessage());
			request.setAttribute(EXCEPTION_MESSAGE, e.getMessage());
			request.getSession().invalidate();
			request.getRequestDispatcher(PageName.ERROR_PAGE).forward(request, response);

		}

		
	}

}
