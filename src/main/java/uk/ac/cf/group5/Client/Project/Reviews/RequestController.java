package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.util.List;


@Controller
public class RequestController {
    private RequestService request;
    private UserService user;

    public  RequestController(RequestService requestService,UserService userService){
        this.request = requestService;
        this.user = userService;
    }
    @GetMapping("/reviews")
    public ModelAndView getReviews(){
        ModelAndView reviews = new ModelAndView("360's/view360's");
        List<UserItem> UserItems = user.getUserItems();
        reviews.addObject("UserItems", UserItems);
        return reviews;
    }
    // change the user item to request.
    private RequestItem mapUserToRequest(UserItem user) {
        RequestItem requestItem = new RequestItem();
        requestItem.setUserId(user.getId());
        requestItem.setUsername(user.getUsername());
        requestItem.setApproved(false);
        return requestItem;
    }
    @GetMapping ("/request360/{id}")
    public ModelAndView MakeRequest(@PathVariable(value = "id" ,required = true) long id){
        UserItem employee = user.getUserItem(id);
        RequestItem requestItem = mapUserToRequest(employee);
        request.add(requestItem);
        return new ModelAndView("redirect:/reviews");
    }
}
