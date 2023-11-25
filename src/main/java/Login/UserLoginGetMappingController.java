package Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginGetMappingController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // This will return the login.html page
    }
}

