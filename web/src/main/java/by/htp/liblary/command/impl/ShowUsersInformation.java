package by.htp.liblary.command.impl;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.command.Command;
import by.htp.liblary.command.exception.CommandException;
import by.htp.liblary.controller.PageName;

import by.htp.liblary.entity.User;
import by.htp.liblary.jsp_bean.JSPUserBean;
import by.htp.liblary.service.UserService;
import by.htp.liblary.service.exception.ServiceException;

public class ShowUsersInformation implements Command {
    private static final String USERBEAN = "userbean";
    private static final String NUMPAGE = "numpage";
    private static final String PREVIOUS_PAGE = "previousPage";

    private static final String PREVIOUS_REQUEST = "previousRequest";
    int interval=3;
    int page = 0;


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        // TODO Auto-generated method stub
        request.getSession().setAttribute(PREVIOUS_PAGE,PageName.ADMIN);
        String pageresult = request.getParameter(NUMPAGE);
        String res=(String)request.getSession().getAttribute("numOfUsers");

        int countAllUsers;

        if (pageresult != null) {
            page = Integer.parseInt(pageresult);
        }
        if(res!=null){
            interval=Integer.parseInt(res);
        }

        List<User> arr;
        try {
            arr = UserService.showUsers(page,interval);
            countAllUsers=UserService.countAllUsers();
            System.out.println("all users" +countAllUsers);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }
        System.out.println(countAllUsers);
        JSPUserBean jsp = new JSPUserBean(arr,countAllUsers,interval);
        request.setAttribute(USERBEAN, jsp);
        Map<String, String[]> params = request.getParameterMap();
        String[] temp;
        temp = params.get("command");
        String commandRes="";

        for (String x : temp) {

            // System.out.println(x);
             commandRes = x;
        }


        StringBuilder str = new StringBuilder();
        str.append(request.getRequestURL());
        str.append("?");
        str.append("command");
        str.append("=");
        str.append(commandRes);


        request.getSession(true).setAttribute(PREVIOUS_REQUEST, str);

        try {
            request.getRequestDispatcher(PageName.SHOW_USERS).forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }
    }

}
