package by.htp.liblary.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;
import by.htp.liblary.controller.PageName;

public class TakeLocalizationPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page;
        // TODO Auto-generated method stub
        page = PageName.LOCAL_PAGE;
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
