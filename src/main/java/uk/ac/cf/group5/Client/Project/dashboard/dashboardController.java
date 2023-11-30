package uk.ac.cf.group5.Client.Project.dashboard;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.Reviews.RequestService;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.util.List;

@Controller
public class dashboardController {

    private RequestService request;
    private UserService user;

    public  dashboardController(RequestService requestService,UserService userService){
        this.request = requestService;
        this.user = userService;
    }
    @GetMapping("/dashboard")
    public ModelAndView getDashboard(Authentication authentication) {
        String username = authentication.getName();
        System.out.println(username);
        UserItem userItem = user.getUserItem(username);
        System.out.println(userItem);
        Long id = userItem.getId();
        System.out.println(id);
        ModelAndView dashboard = new ModelAndView("dashboard/user");
        List<RequestItem> requestItems = request.getRequestItems(id);
        dashboard.addObject("requestItems", requestItems);
        return dashboard;
    }
}
