package uk.ac.cf.group5.Client.Project.Reviews;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView getReviews(Authentication authentication){
        //String employee = authentication.getName();
        //UserItem userItem = user.getUserItem(employee);
        //Long id =  userItem.getId();
        ModelAndView reviews = new ModelAndView("360's/view360's");
        //List<RequestItem> requestItems = request.getRequestItems(id);
        //reviews.addObject("RequestItems", requestItems);
        return reviews;
    }

    @GetMapping("/requests")
    public ModelAndView getRequest(Authentication authentication){
        String employee = authentication.getName();
       UserItem userItem = user.getUserItem(employee);
        Long id =  userItem.getId();
        ModelAndView requests = new ModelAndView("360's/requests");
        List<RequestItem> requestItems = request.getRequestItems(id);
       requests.addObject("requestItems", requestItems);
        return requests;

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

        return new ModelAndView("redirect:requests");
    }
}
