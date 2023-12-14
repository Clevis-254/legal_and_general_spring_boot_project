package uk.ac.cf.group5.Client.Project.Form.Contacts.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.ac.cf.group5.Client.Project.Admin.EmailService;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactService;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ContactEmailController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ContactEmailService contactEmailService;

    @Autowired
    private UserService userService;

    @GetMapping("/form/employee/email/{reviewId}")
    public String sendContactEmail(@PathVariable("reviewId") long reviewId) {
        List<ContactItem> contacts = contactService.getContactItems(reviewId);
        // Get review information from the ReviewService
        ReviewItem review = reviewService.getItem(reviewId);
        Long userId = review.getUserId();

        // Get user information from the UserService
        UserItem user = userService.getItem(userId);
        String empName = user.getFirstname();

        for (ContactItem contact : contacts) {
            String email = contact.getEmail();
            String Contactname = contact.getFirstName() + ' ' + contact.getLastName();
            Long contactid = contact.getId();
            contactEmailService.sendContactEmail(email, Contactname, empName, contactid);
        }
    return "redirect:/thankYou"; }
}
