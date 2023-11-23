package uk.ac.cf.group5.Client.Project.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dashboardController {
    @GetMapping("/")
    public ModelAndView getDashboard(){
        ModelAndView dashboard = new ModelAndView("dashboard/user");
        return dashboard;
    }

}
