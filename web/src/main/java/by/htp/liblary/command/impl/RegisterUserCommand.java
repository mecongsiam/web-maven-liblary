package by.htp.liblary.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;
import by.htp.liblary.controller.PageName;
import by.htp.liblary.service.UserService;
import by.htp.liblary.service.exception.ServiceException;

public class RegisterUserCommand implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String ADRESS = "address";
    private static final String PHONE = "phone";
    private static final String ROLE = "userRole";
    private static final String LOGIN_ERROR = "loginError";
    private static final String LOGIN_DUALITY_ERROR = "loginDualityError";
    private static final String PASSWORD_ERROR = "passwordError";
    private static final String NAME_ERROR = "nameError";
    private static final String SURNAME_ERROR = "surnameError";
    private static final String EMAIL_ERROR = "emailError";
    private static final String EMAIL_DUALITY_ERROR = "emailDualityError";
    private static final String ADDRESS_ERROR = "addressError";
    private static final String PHONE_ERROR = "phoneError";
    private static final String ROLE_ERROR = "roleError";
    private static final String RESULT_ADDUSER_MESSAGE = "resultAddUserMessage";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        boolean result = false;
        boolean resultLogin = false;
        boolean resultLoginDuality = false;
        boolean resultPassword = false;
        boolean resultName = false;
        boolean resultSurname = false;
        boolean resultEmail = false;
        boolean resultEmailDuality = false;
        boolean resultAddress = false;
        boolean resultPhone = false;
        boolean resultUserRole = false;

        String page = null;

        request.getSession(true).setAttribute(LOGIN_ERROR, false);
        request.getSession(true).setAttribute(PASSWORD_ERROR, false);
        request.getSession(true).setAttribute(NAME_ERROR, false);
        request.getSession(true).setAttribute(SURNAME_ERROR, false);
        request.getSession(true).setAttribute(EMAIL_ERROR, false);
        request.getSession(true).setAttribute(ADDRESS_ERROR, false);
        request.getSession(true).setAttribute(PHONE_ERROR, false);
        request.getSession(true).setAttribute(ROLE_ERROR, false);
        request.getSession(true).setAttribute(EMAIL_DUALITY_ERROR, false);
        request.getSession(true).setAttribute(LOGIN_DUALITY_ERROR, false);

        resultLogin = UserService.regLoginValidator(request.getParameter(LOGIN));
        resultPassword = UserService.regPasswordValidator(request.getParameter(PASSWORD));
        resultName = UserService.reqNameValidator(request.getParameter(NAME));
        resultSurname = UserService.reqSurnameValidator(request.getParameter(SURNAME));
        resultEmail = UserService.reqEmailValidator(request.getParameter(EMAIL));
        resultAddress = UserService.reqAdressValidator(request.getParameter(ADRESS));
        resultPhone = UserService.reqPhoneValidator(request.getParameter(PHONE));
        resultUserRole = UserService.reqRoleValidator(request.getParameter(ROLE));
        try {
            resultLoginDuality = UserService.reqLoginDualityValidator(request.getParameter(LOGIN));
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }
        try {
            resultEmailDuality = UserService.regEmailDualityValidatoe(request.getParameter(EMAIL));
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }

        if (!resultLogin) {
            request.getSession(true).setAttribute(LOGIN_ERROR, true);
        }
        if (!resultPassword) {
            request.getSession(true).setAttribute(PASSWORD_ERROR, true);
        }
        if (!resultName) {
            request.getSession(true).setAttribute(NAME_ERROR, true);
        }
        if (!resultSurname) {
            request.getSession(true).setAttribute(SURNAME_ERROR, true);
        }
        if (!resultEmail) {
            request.getSession(true).setAttribute(EMAIL_ERROR, true);
        }
        if (!resultAddress) {
            request.getSession(true).setAttribute(ADDRESS_ERROR, true);
        }
        if (!resultPhone) {
            request.getSession(true).setAttribute(PHONE_ERROR, true);
        }
        if (!resultUserRole) {
            request.getSession(true).setAttribute(ROLE_ERROR, true);
        }
        if (!resultLoginDuality) {

            request.getSession(true).setAttribute(LOGIN_DUALITY_ERROR, true);

        }
        if (!resultEmailDuality) {
            request.getSession(true).setAttribute(EMAIL_DUALITY_ERROR, true);

        }

        if (resultLogin & resultPassword & resultName & resultSurname & resultEmail & resultAddress & resultPhone
                & resultUserRole & resultLoginDuality & resultEmailDuality) {

            try {
                result = UserService.regUser(request.getParameter(LOGIN), request.getParameter(PASSWORD),
                        request.getParameter(NAME), request.getParameter(SURNAME), request.getParameter(EMAIL),
                        request.getParameter(ADRESS), request.getParameter(PHONE), request.getParameter(ROLE));
            } catch (ServiceException e) {
                // TODO Auto-generated catch block
                throw new CommandException(e.getMessage(), e);
            }
            if (result) {
                request.getSession().setAttribute(RESULT_ADDUSER_MESSAGE, true);
                page = PageName.REGISTER;
            } else {
                page = PageName.ERROR_PAGE;
            }
            try {
                request.getRequestDispatcher(page).forward(request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                throw new CommandException(e.getMessage(), e);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                throw new CommandException(e.getMessage(), e);
            }
        } else {
            try {

                request.getRequestDispatcher(PageName.REGISTER).forward(request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                throw new CommandException(e.getMessage(), e);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                throw new CommandException(e.getMessage(), e);
            }
        }

    }

}
