package uk.ac.cf.group5.Client.Project.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.user.UserService;

@Controller
public class LoginController {
    private UserService user;

    public  LoginController( UserService userService){
        this.user = userService;
    }

    @GetMapping("/login")
    public ModelAndView Login(){
        ModelAndView login = new ModelAndView("/LoginPage");
        return login;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:dashboard";
    }
}
