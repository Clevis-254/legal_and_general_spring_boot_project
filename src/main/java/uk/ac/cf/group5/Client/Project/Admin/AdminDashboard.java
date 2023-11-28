package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminDashboard {
    @GetMapping("/Admin/AdminDashboard")
    ModelAndView Admin(){ModelAndView adminPage = new ModelAndView("/Admin/AdminDashboard"); return adminPage;}
}

