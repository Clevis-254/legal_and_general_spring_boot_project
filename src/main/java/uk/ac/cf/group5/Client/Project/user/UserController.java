package uk.ac.cf.group5.Client.Project.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserService user;

    public  UserController( UserService userService){
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
