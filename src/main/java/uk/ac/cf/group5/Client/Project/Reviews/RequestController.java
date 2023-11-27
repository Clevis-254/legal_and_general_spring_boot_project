package uk.ac.cf.group5.Client.Project.Reviews;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return reviews;
    }


    @GetMapping("/request360")
    public ModelAndView makeRequest(/*@AuthenticationPrincipal UserDetails userDetails*/
    Authentication authentication) {

/*        String employee = userDetails.getUsername();*/

        String employee = authentication.getName();
        UserItem userItem = user.getUserItem(employee);

        RequestItem requestItem = new RequestItem();
        requestItem.setUsername(userItem.getUsername());
        requestItem.setUserId(userItem.getId());

        request.add(requestItem);

        return new ModelAndView("redirect:reviews");
    }
}
