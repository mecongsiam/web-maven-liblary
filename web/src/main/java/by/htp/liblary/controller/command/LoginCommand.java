package by.htp.liblary.controller.command;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginCommand {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin";
    }
}
