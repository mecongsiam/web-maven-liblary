package by.htp.liblary.controller.command;

import by.htp.liblary.controller.command.exception.CommandException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by meco on 15.06.2016.
 */
@Controller
public class AddPosition  {
    private static final String PREVIOUS_REQUEST = "previousRequest";
    @RequestMapping(value = "/add_position",method = RequestMethod.GET)
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        int position;
        position=(Integer)request.getSession().getAttribute("position");
        position++;
        request.getSession().setAttribute("position",position);
        try {
            response.sendRedirect(request.getSession(true).getAttribute(PREVIOUS_REQUEST).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
