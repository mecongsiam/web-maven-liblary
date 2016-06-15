package by.htp.liblary.command.impl;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;
import by.htp.liblary.controller.PageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by meco on 15.06.2016.
 */
public class ChangeInterval implements Command {
    private static final String PREVIOUS_REQUEST = "previousRequest";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String interval =request.getParameter("userInterval");
        System.out.println(interval);
        request.getSession().setAttribute("numOfUsers",interval);
        try {
            response.sendRedirect(request.getSession(true).getAttribute(PREVIOUS_REQUEST).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
