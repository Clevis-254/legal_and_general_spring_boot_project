package uk.ac.cf.group5.Client.Project.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    @PostMapping("/login")
    public String login(Model model) {
        // Your login logic here

        return "redirect:/dashboard";
    }
}