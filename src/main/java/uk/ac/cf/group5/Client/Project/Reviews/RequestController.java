package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;

import java.util.List;


@Controller
public class RequestController {
    private RequestService request;
    private UserService user;

    private ReviewService review;

    public  RequestController(RequestService requestService,UserService userService, ReviewService reviewService){
        this.request = requestService;
        this.user = userService;
        this.review = reviewService;
    }
    @GetMapping("/reviews")
    public ModelAndView getReviews(Authentication authentication) {
        String employee = authentication.getName();
        UserItem userItem = user.getUserItem(employee);
        Long userId = userItem.getId();

        ModelAndView reviews = new ModelAndView("360's/reviews");
        List<RequestItem> reviewItems = review.getReviewItems(userId);
        reviews.addObject("reviewItems", reviewItems);

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
        requestItem.setName(userItem.getName());
        requestItem.setUserId(userItem.getId());

        request.add(requestItem);

        return new ModelAndView("redirect:requests");
    }
}
