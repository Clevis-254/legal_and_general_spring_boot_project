package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

@Controller
public class AdminDashboard {

    private ViewRequestsImpl viewRequestsImpl;

    public AdminDashboard(ViewRequestsImpl aViewRequestsImpl) {
        this.viewRequestsImpl = aViewRequestsImpl;
    }
    @GetMapping("/Admin/AdminDashboard")
    public ModelAndView GetAdminDashboard(){
        ModelAndView adminDashboard = new ModelAndView("Admin/AdminDashboard");
        List<RequestItem> allRequestItems = viewRequestsImpl.getPendingRequestItems();
        adminDashboard.addObject("allRequestItems",allRequestItems);
        return adminDashboard;
    }

}

