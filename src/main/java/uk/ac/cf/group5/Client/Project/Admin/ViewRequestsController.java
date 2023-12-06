package uk.ac.cf.group5.Client.Project.Admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import java.util.List;

@Controller
public class ViewRequestsController {
    private ViewRequestsImpl viewRequestsImpl;


    public ViewRequestsController(ViewRequestsImpl aViewRequestsImpl) {
        this.viewRequestsImpl = aViewRequestsImpl;
    }
    @GetMapping("Admin/ViewRequests")
    public ModelAndView getViewRequests(){
        ModelAndView ViewRequests = new ModelAndView("Admin/ViewRequests");
        List<RequestItem> allRequestItems = viewRequestsImpl.getAllRequestItems();
        ViewRequests.addObject("allRequestItems", allRequestItems);
        return ViewRequests;
    }
}
