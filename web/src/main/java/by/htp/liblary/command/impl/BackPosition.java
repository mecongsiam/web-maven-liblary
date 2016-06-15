package by.htp.liblary.command.impl;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by meco on 16.06.2016.
 */
public class BackPosition implements Command {

    private static final String PREVIOUS_REQUEST = "previousRequest";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        int position;
        position=(Integer)request.getSession().getAttribute("position");
        if(position>0){
            position--;
        }

        request.getSession().setAttribute("position",position);
        try {
            response.sendRedirect(request.getSession(true).getAttribute(PREVIOUS_REQUEST).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
