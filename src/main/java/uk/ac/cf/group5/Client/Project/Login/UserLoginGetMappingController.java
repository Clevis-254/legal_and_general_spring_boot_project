package uk.ac.cf.group5.Client.Project.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginGetMappingController {

    @GetMapping("/login")
    public ModelAndView LoginForm() {

        ModelAndView Login = new ModelAndView("/LoginPage");
        return Login;
    }
}

