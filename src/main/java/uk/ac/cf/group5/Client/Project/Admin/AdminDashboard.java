package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.util.List;

@Controller
public class AdminDashboard {

    @Autowired
    private ViewRequestsImpl viewRequestsImpl;

    @Autowired
   private UserService user;

    public AdminDashboard(ViewRequestsImpl aViewRequestsImpl) {
        this.viewRequestsImpl = aViewRequestsImpl;
    }
    @GetMapping("/Admin/AdminDashboard")
    public ModelAndView GetAdminDashboard(){
        ModelAndView adminDashboard = new ModelAndView("Admin/AdminDashboard");
        List<RequestItem> allRequestItems = viewRequestsImpl.getPendingRequestItems();
        List<UserItem> allUserItems = user.getUserItems();
        adminDashboard.addObject("allRequestItems",allRequestItems);
        adminDashboard.addObject("allUserItems",allUserItems);
        return adminDashboard;
    }

}

