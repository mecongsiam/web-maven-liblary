package by.htp.liblary.controller.command;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.controller.command.exception.CommandException;
import by.htp.liblary.controller.PageName;

import by.htp.liblary.entity.User;
import by.htp.liblary.jsp_bean.JSPUserBean;
import by.htp.liblary.service.IUserService;
import by.htp.liblary.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowUsersInformation  {
    private static final String USERBEAN = "userbean";
    private static final String NUMPAGE = "numpage";
    private static final String PREVIOUS_PAGE = "previousPage";
    private static final String PREVIOUS_REQUEST = "previousRequest";
    private int interval=3;
    private int page = 0;
    private int position=0;
    private int maxNumPosition;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/show_users",method = RequestMethod.GET)
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        // TODO Auto-generated method stub
        if (request.getSession().getAttribute("position")==null){
            request.getSession().setAttribute("position",0);
        }
        position=((Integer)request.getSession().getAttribute("position"));
        System.out.println("POS"+position);
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
            arr = userService.showUsers(page,interval);
            countAllUsers=userService.countAllUsers();
            System.out.println("all users" +countAllUsers);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }

        maxNumPosition=((countAllUsers/interval)/3);
        if(position>maxNumPosition){
            position=maxNumPosition;
            request.getSession().setAttribute("position",maxNumPosition);
        }
        JSPUserBean jsp = new JSPUserBean(arr,countAllUsers,interval,position);
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
