package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMenuController {
    @GetMapping ("Admin/AdminMenu")
    public ModelAndView Admin(){
        ModelAndView adminMenu = new ModelAndView("Admin/AdminMenu");
        return adminMenu;
    }
}