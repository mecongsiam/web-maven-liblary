package by.htp.liblary.controller.command;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.liblary.controller.command.exception.CommandException;
import by.htp.liblary.controller.PageName;

import by.htp.liblary.entity.Book;
import by.htp.liblary.jsp_bean.JSPBookBean;

import by.htp.liblary.service.IUserService;
import by.htp.liblary.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ShowCatalogCommand {
    private static final String USERBEAN = "userbean";
    private static final String PREVIOUS_PAGE = "previousPage";

    @Autowired
    IUserService userService;

   @RequestMapping(value = "/show_catalog",method = RequestMethod.GET)
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        // TODO Auto-generated method stub
        // return null;
        request.getSession().setAttribute(PREVIOUS_PAGE,PageName.ADMIN);
        List<Book> arr;
        try {
            arr = userService.showBooks();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }
        JSPBookBean jsp = new JSPBookBean(arr);
        request.setAttribute(USERBEAN, jsp);

        try {
            request.getRequestDispatcher(PageName.SHOW_BOOKS).forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new CommandException(e.getMessage(), e);
        }
    }

}