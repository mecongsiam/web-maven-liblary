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
public class TakeRegisterPage  {
    private static final String PREVIOUS_PAGE = "previousPage";
    private static final String LOGIN_ERROR = "loginError";
    private static final String PASSWORD_ERROR = "passwordError";
    private static final String NAME_ERROR = "nameError";
    private static final String SURNAME_ERROR = "surnameError";
    private static final String EMAIL_ERROR = "emailError";
    private static final String ADDRESS_ERROR = "addressError";
    private static final String PHONE_ERROR = "phoneError";
    private static final String ROLE_ERROR = "roleError";
    private static final String RESULT_ADDUSER_MESSAGE = "resultAddUserMessage";

    @RequestMapping(value = "/create_user",method = RequestMethod.GET)
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.getSession(true).setAttribute(LOGIN_ERROR, false);
        request.getSession(true).setAttribute(PASSWORD_ERROR, false);
        request.getSession(true).setAttribute(NAME_ERROR, false);
        request.getSession(true).setAttribute(SURNAME_ERROR, false);
        request.getSession(true).setAttribute(EMAIL_ERROR, false);
        request.getSession(true).setAttribute(ADDRESS_ERROR, false);
        request.getSession(true).setAttribute(PHONE_ERROR, false);
        request.getSession(true).setAttribute(ROLE_ERROR, false);
        request.getSession(true).setAttribute(RESULT_ADDUSER_MESSAGE, false);

        String page;

        page = PageName.REGISTER;
        request.getSession().setAttribute(PREVIOUS_PAGE, PageName.ADMIN);
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}