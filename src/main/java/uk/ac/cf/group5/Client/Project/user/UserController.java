package uk.ac.cf.group5.Client.Project.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/logout")
    public String logout(){
        return "redirect:login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
    @GetMapping("/LoginSuccess")
    public void LoginSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws Exception, ServletException {
        String role = authResult.getAuthorities().toString();

        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/Admin/AdminMenu"));
        }
        else if(role.contains("ROLE_USER")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/dashboard"));

        }
        else {response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/login"));

        }
    }

}
