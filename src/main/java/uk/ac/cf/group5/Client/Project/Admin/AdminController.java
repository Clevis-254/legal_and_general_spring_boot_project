package uk.ac.cf.group5.Client.Project.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @GetMapping ("Admin/AdminMenu")
    public ModelAndView Admin(){
        ModelAndView adminMenu = new ModelAndView("Admin/AdminMenu");
        return adminMenu;
    }
    @GetMapping("/Admin/LoginSuccess")
    public void LoginSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
            throws Exception, ServletException {
        String role = authResult.getAuthorities().toString();

        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "Admin/AdminMenu"));
        }
        else if(role.contains("ROLE_USER")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"dashboard"));

        }

    }
    @GetMapping("/Admin/AdminDashboard")
    public ModelAndView GetAdminDashboard(){
        ModelAndView adminDashboard = new ModelAndView("/Admin/AdminDashboard");
        return adminDashboard;
    }
}
