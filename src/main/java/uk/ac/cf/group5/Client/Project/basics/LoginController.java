package uk.ac.cf.group5.Client.Project.basics;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Reviews.RequestService;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;


@Controller
public class LoginController {

    private UserService user;

    public  LoginController( UserService userService){
        this.user = userService;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:LoginSuccess";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/LoginSuccess")
    public ModelAndView LoginSuccess(Authentication authResult) throws Exception {
        String name = authResult.getName();
        UserItem userItem = user.getUserItem(name);
        String role = userItem.getRole();

        if (role.contains("ROLE_ADMIN")) {
            return new ModelAndView("redirect:/Admin/AdminMenu");
        } else if (role.contains("ROLE_USER")) {
            return new ModelAndView("redirect:/dashboard");
        }
        // Default redirect in case the role is neither ROLE_ADMIN nor ROLE_USER
        return new ModelAndView("redirect:/dashboard");
    }
}
