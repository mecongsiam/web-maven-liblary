package by.htp.liblary.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.controller.command.exception.CommandException;
import by.htp.liblary.controller.PageName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Exit  {

	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		// TODO Auto-generated method stub
		request.getSession().invalidate();

		try {
			request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
