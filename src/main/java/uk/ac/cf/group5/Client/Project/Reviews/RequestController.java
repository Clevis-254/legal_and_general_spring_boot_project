package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.AnswerDTO.AnswerDTO;
import uk.ac.cf.group5.Client.Project.AnswerDTO.AnswerServiceDTO;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RequestController {
    private RequestService request;
    private UserService user;

    private ReviewService review;

    private AnswerServiceDTO DTO;

    public RequestController(RequestService requestService, UserService userService, ReviewService reviewService,
                             AnswerServiceDTO answerServiceDTO) {
        this.request = requestService;
        this.user = userService;
        this.review = reviewService;
        this.DTO = answerServiceDTO;
    }

    @GetMapping("/Reviews")
    public ModelAndView getReviews(Authentication authentication) {
        String employee = authentication.getName();
        UserItem userItem = user.getUserItem(employee);
        Long userId = userItem.getId();
        ModelAndView reviews = new ModelAndView("360's/Reviews");
        List<ReviewItem> reviewItems = review.getReviewItems(userId);
        reviews.addObject("reviewItems", reviewItems);

        return reviews;
    }

/*    @GetMapping("/Reviews")
    public ModelAndView getViewReviews() {
        ModelAndView viewReviews = new ModelAndView("360's/Reviews");
        List<ReviewItem> allReviewItems = ReviewRepoImp.getInProgressReviewItems();
        viewReviews.addObject("allReviewItems", allReviewItems);
        return viewReviews;
    }*/

    @GetMapping("/requests")
    public ModelAndView getRequest(Authentication authentication) {
        String employee = authentication.getName();
        UserItem userItem = user.getUserItem(employee);
        Long id = userItem.getId();
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
        requestItem.setFirstname(userItem.getFirstname());

        requestItem.setUserId(userItem.getId());

        request.add(requestItem);

        return new ModelAndView("redirect:requests");
    }

    @GetMapping("/results/{id}")
    public ModelAndView getResults(@PathVariable Long id) {
        ModelAndView piechart = new ModelAndView("360's/Results");
        List<AnswerDTO> answers = DTO.getAnswersGroupedByCategory();
        List<AnswerDTO> contacts = DTO.getAnswersGroupedByContact();
        piechart.addObject("answers", answers);
        // Create a map to store the sum and count for each contact category
        Map<String, Double[]> categoryData = new HashMap<>();

    // Iterate over the answerDTOs and calculate the sum and count for each contact category
        for (AnswerDTO answerDTO : contacts) {
            if ("Collaborative".equals(answerDTO.getQuestionCategory())) {
                String contactCategory = answerDTO.getContactCategory();
                double answerValue = Double.parseDouble(answerDTO.getAnswer());

                if (categoryData.containsKey(contactCategory)) {
                    Double[] data = categoryData.get(contactCategory);
                    data[0] += answerValue; // Sum
                    data[1]++; // Count
                } else {
                    categoryData.put(contactCategory, new Double[]{answerValue, 1.0});
                }
            }
        }

    // Calculate the average for each contact category
        Map<String, Double> collaborative = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : categoryData.entrySet()) {
            String contactCategory = entry.getKey();
            Double[] data = entry.getValue();
            double average = data[0] / data[1];
            collaborative.put(contactCategory, average);
        }

    // Pass the averages map to the Thymeleaf template
        piechart.addObject("collaborative", collaborative);

        // Iterate over the answerDTOs and calculate the sum and count for each contact category
        for (AnswerDTO answerDTO : contacts) {
            if ("Purposeful".equals(answerDTO.getQuestionCategory())) {
                String contactCategory = answerDTO.getContactCategory();
                double answerValue = Double.parseDouble(answerDTO.getAnswer());

                if (categoryData.containsKey(contactCategory)) {
                    Double[] data = categoryData.get(contactCategory);
                    data[0] += answerValue; // Sum
                    data[1]++; // Count
                } else {
                    categoryData.put(contactCategory, new Double[]{answerValue, 1.0});
                }
            }
        }

        // Calculate the average for each contact category
        Map<String, Double>Purposeful = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : categoryData.entrySet()) {
            String contactCategory = entry.getKey();
            Double[] data = entry.getValue();
            double average = data[0] / data[1];
            Purposeful.put(contactCategory, average);
        }

        // Pass the averages map to the Thymeleaf template
        piechart.addObject("Purposeful", Purposeful);


        // Iterate over the answerDTOs and calculate the sum and count for each contact category
        for (AnswerDTO answerDTO : contacts) {
            if ("Straight-Forward".equals(answerDTO.getQuestionCategory())) {
                String contactCategory = answerDTO.getContactCategory();
                double answerValue = Double.parseDouble(answerDTO.getAnswer());

                if (categoryData.containsKey(contactCategory)) {
                    Double[] data = categoryData.get(contactCategory);
                    data[0] += answerValue; // Sum
                    data[1]++; // Count
                } else {
                    categoryData.put(contactCategory, new Double[]{answerValue, 1.0});
                }
            }
        }

// Calculate the average for each contact category
        Map<String, Double> straightForwardAverages = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : categoryData.entrySet()) {
            String contactCategory = entry.getKey();
            Double[] data = entry.getValue();
            double average = data[0] / data[1];
            straightForwardAverages.put(contactCategory, average);
        }

        // Pass the averages map to the Thymeleaf template
        piechart.addObject("straightForwardAverages", straightForwardAverages);


        // Iterate over the answerDTOs and calculate the sum and count for each contact category
        for (AnswerDTO answerDTO : contacts) {
            if ("Authentic".equals(answerDTO.getQuestionCategory())) {
                String contactCategory = answerDTO.getContactCategory();
                double answerValue = Double.parseDouble(answerDTO.getAnswer());

                if (categoryData.containsKey(contactCategory)) {
                    Double[] data = categoryData.get(contactCategory);
                    data[0] += answerValue; // Sum
                    data[1]++; // Count
                } else {
                    categoryData.put(contactCategory, new Double[]{answerValue, 1.0});
                }
            }
        }

        // Calculate the average for each contact category
        Map<String, Double> Authentic = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : categoryData.entrySet()) {
            String contactCategory = entry.getKey();
            Double[] data = entry.getValue();
            double average = data[0] / data[1];
            Authentic.put(contactCategory, average);
        }

        // Pass the averages map to the Thymeleaf template
        piechart.addObject("Authentic", Authentic);


        // Iterate over the answerDTOs and calculate the sum and count for each contact category
        for (AnswerDTO answerDTO : contacts) {
            if ("Agile".equals(answerDTO.getQuestionCategory())) {
                String contactCategory = answerDTO.getContactCategory();
                double answerValue = Double.parseDouble(answerDTO.getAnswer());

                if (categoryData.containsKey(contactCategory)) {
                    Double[] data = categoryData.get(contactCategory);
                    data[0] += answerValue; // Sum
                    data[1]++; // Count
                } else {
                    categoryData.put(contactCategory, new Double[]{answerValue, 1.0});
                }
            }
        }

        // Calculate the average for each contact category
        Map<String, Double> Agile = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : categoryData.entrySet()) {
            String contactCategory = entry.getKey();
            Double[] data = entry.getValue();
            double average = data[0] / data[1];
            Agile.put(contactCategory, average);
        }

        // Pass the averages map to the Thymeleaf template
        piechart.addObject("Agile", Agile);


        // Iterate over the answerDTOs and calculate the sum and count for each contact category
        for (AnswerDTO answerDTO : contacts) {
            if ("Ambitious".equals(answerDTO.getQuestionCategory())) {
                String contactCategory = answerDTO.getContactCategory();
                double answerValue = Double.parseDouble(answerDTO.getAnswer());

                if (categoryData.containsKey(contactCategory)) {
                    Double[] data = categoryData.get(contactCategory);
                    data[0] += answerValue; // Sum
                    data[1]++; // Count
                } else {
                    categoryData.put(contactCategory, new Double[]{answerValue, 1.0});
                }
            }
        }

        // Calculate the average for each contact category
        Map<String, Double> Ambitious = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : categoryData.entrySet()) {
            String contactCategory = entry.getKey();
            Double[] data = entry.getValue();
            double average = data[0] / data[1];
            collaborative.put(contactCategory, average);
        }

        // Pass the averages map to the Thymeleaf template
        piechart.addObject("Ambitious", Ambitious);
        return piechart;
    }
}
