package uk.ac.cf.group5.Client.Project;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/LoginSuccess")
//    public void LoginSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws Exception, ServletException{
//        String role = authResult.getAuthorities().toString();
//
//        if(role.contains("ROLE_ADMIN")){
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/Admin/AdminMenu"));
//        }
//        else if(role.contains("ROLE_USER")){
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/dashboard"));
//
//        }
//
//    }


}
