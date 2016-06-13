package by.htp.liblary.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;

public class UnknownCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        // TODO Auto-generated method stub
        // return null;
    }

}
