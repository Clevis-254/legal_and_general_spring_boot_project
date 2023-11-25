package Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {private static final String userEmail = "user@gmail.com";
    private static final String userPassword = "user123";


    @PostMapping("/login")
    public String login(String email, String password, Model model) {
        try {

            if (isValidUser(email, password)) {
                model.addAttribute("message", "You logged in successfully!");
                return "redirect:/dashboard";
            } else {
                model.addAttribute("error", "Sorry Invalid email or password.");
                return ("redirect:/login");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Unexpected error. Please try again later.");
            return "login";
        }

    }

    private boolean isValidUser(java.lang.String email, java.lang.String password) {
        return email.equals(userEmail) && password.equals(userPassword);}
}
