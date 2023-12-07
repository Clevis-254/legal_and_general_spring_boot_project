package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewRequestService;

    @GetMapping("/review")
    public ModelAndView getInProgressReviews(ModelAndView modelAndView, Principal principal) {
        Long userId = getUserIdFromPrincipal(principal);

        List<ReviewItem> inProgressReviewRequests = reviewRequestService.getInProgressReviews(userId);

        modelAndView.addObject("inProgressReviewRequests", inProgressReviewRequests);
        modelAndView.setViewName("360's/view360's");

        return modelAndView;
    }

    private Long getUserIdFromPrincipal(Principal principal) {
        return null;
    }
}
