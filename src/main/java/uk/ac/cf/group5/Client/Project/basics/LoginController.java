package uk.ac.cf.group5.Client.Project.basics;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(Model model) {

        return "redirect:/dashboard";
    }
}
