package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewRequestsController {
    @GetMapping("Admin/ViewRequests")
    public ModelAndView getViewRequests(){
        ModelAndView ViewRequests = new ModelAndView("Admin/ViewRequests");
        return ViewRequests;
    }
}
