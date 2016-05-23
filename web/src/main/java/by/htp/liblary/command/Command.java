package by.htp.liblary.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.exception.CommandException;

public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
