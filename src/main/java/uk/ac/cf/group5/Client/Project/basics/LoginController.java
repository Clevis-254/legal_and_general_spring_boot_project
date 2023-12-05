package uk.ac.cf.group5.Client.Project.basics;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
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
