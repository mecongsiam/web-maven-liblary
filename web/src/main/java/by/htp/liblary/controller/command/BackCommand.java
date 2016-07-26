package by.htp.liblary.controller.command;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import by.htp.liblary.controller.command.exception.CommandException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackCommand {
	@RequestMapping(value = "/back",method = RequestMethod.POST)

	public void execute(HttpServletResponse response) throws CommandException {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("/liblary/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
