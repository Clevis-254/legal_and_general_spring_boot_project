package uk.ac.cf.group5.Client.Project.Form;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Answer.AnswerItem;
import uk.ac.cf.group5.Client.Project.Answer.AnswerService;
import uk.ac.cf.group5.Client.Project.Form.employeeForms.QuestionItem;
import uk.ac.cf.group5.Client.Project.Form.employeeForms.QuestionService;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;
import uk.ac.cf.group5.Client.Project.Submissions.SubmissionItem;
import uk.ac.cf.group5.Client.Project.Submissions.SubmissionService;
import uk.ac.cf.group5.Client.Project.Form.contactForms.ContactQuestionService;
import uk.ac.cf.group5.Client.Project.Form.contactForms.questionItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactService;
import uk.ac.cf.group5.Client.Project.Form.employeeForms.QuestionItem;
import uk.ac.cf.group5.Client.Project.Form.employeeForms.QuestionService;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    private List<String> categories = new ArrayList<>();

    @Autowired
    private QuestionService questionService;


    @Autowired
    private ContactQuestionService question;
    private final ContactService contactService;


    private ReviewService review;
    @Autowired
    private SubmissionService submission;
    @Autowired
    private AnswerService answerService;


    private UserService user;
    public FormController(QuestionService questionService, ContactService contactService,UserService service,
                          ReviewService reviewService, SubmissionService submissionService, AnswerService aservices){
        this.questionService = questionService;
        this.contactService = contactService;
        this.user = service;
        this.review = reviewService;
        this.submission = submissionService;
        this.answerService = aservices;
        List<String> categoriesToAdd = new ArrayList<>();
        categoriesToAdd.add("Collaborative");
        categoriesToAdd.add("Purposeful");
        categoriesToAdd.add("Straight-Forward");
        categoriesToAdd.add("Authentic");
        categoriesToAdd.add("Agile");
        categoriesToAdd.add("Ambitious");
        this.categories = categoriesToAdd;
    }

    public void receiveAnswer(Long submissionid, String answers){
        try { ObjectMapper objectMapper = new ObjectMapper();
            List<AnswerItem> answerList = objectMapper.readValue(answers,
                    new TypeReference<List<AnswerItem>>() {});
            for (AnswerItem answer : answerList) {
                answer.setSub_id(submissionid);
                Long questionId = answer.getQuestion_id();
                String answerText = answer.getAnswer();
                SubmissionItem submissionItem = submission.getSubmission(submissionid);
                Long review = submissionItem.getReviewID();
                answer.setRev_id(review);
            }
            answerService.add(answerList);
            //return "Success";
            // Replace with your response
        } catch (IOException e) {
            // Handle JSON parsing exception
            e.printStackTrace();
            //return "Error"; //
            // Replace with your error response
        }
    }

    /*
    perhaps should add an id to reference the user answering the form questions.
     */
    @GetMapping("/form/{id}/employee")
    public ModelAndView getEmployeeForm(@PathVariable Long id, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("form/employeeForm");
        modelAndView.addObject("categories", categories);
        String employee = authentication.getName();
        UserItem userItem = user.getUserItem(employee);
        Long userId = userItem.getId();
        ReviewItem reviewItem = review.getReview(userId);
        Long reviewId = reviewItem.getId();
        submission.add(null,reviewId,userId);
        SubmissionItem submissionItem = submission.getSubmission(id);
        modelAndView.addObject("submissionItem",submissionItem);
        Date date = review.getDateForQ(id);
        System.out.println(date);
        List<QuestionItem> questions = questionService.getRadioQuestions(date);
        System.out.println(questions);
        modelAndView.addObject("questions", questions);
        List<QuestionItem> textAreaQuestions = questionService.getTextAreaQuestions(date);
        System.out.println(textAreaQuestions);
        modelAndView.addObject("textAreaQuestions", textAreaQuestions);
        return modelAndView;
    }

    @PostMapping("/form/{id}/employee")
    public String receiveEmployeeAnswer(@PathVariable Long id,@RequestParam("questionAnswers") String answers){
        receiveAnswer(id,answers);
        return "redirect:/form/{id}/employee/contacts";
    }


    @GetMapping("/form/{id}/employee/contacts")
    public ModelAndView getEmployeeContacts(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("form/contacts");
        ReviewItem reviewItem = review.getItem(id);
        modelAndView.addObject("reviewItem",reviewItem);
        modelAndView.addObject("reviewID", id);
        modelAndView.addObject("contact", new ContactItem());
        modelAndView.addObject("managerCount", contactService.getManagerCount(id));
        modelAndView.addObject("peerCount",contactService.getPeerCount(id));
        modelAndView.addObject("externalCount",contactService.getExternalCount(id));
        List<ContactItem> contacts = contactService.getContactItems(id); // Fetch contacts from the database
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @PostMapping("/form/{id}/addContact")
    public String addContact(@ModelAttribute ContactItem contact, @PathVariable Long id) {
        // Process and save the received contact to the database
        System.out.println(contact.toString());
        Long contactID =  contactService.save(contact, id); // Save the contact and get the saved contact// Retrieve the contact ID from the saved contact
        submission.add(contactID, id, null);

        return "redirect:/form/{id}/employee/contacts"; // Redirect to the contact form page
    }

    @GetMapping("/form/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id){
            // Delete contact by id
            contactService.delete(id);
        return "redirect:/form/{id}/employee/contacts"; // Redirect back to the contacts list
    }


    @GetMapping("/thankYou")
    public ModelAndView getThankYou() {
        ModelAndView modelAndView = new ModelAndView("form/thankYou");
        return modelAndView;
    }

    @GetMapping("/form/{id}/contactForm")
    public ModelAndView sentForm(@PathVariable Long id){
        ModelAndView contact = new ModelAndView("form/contactForm");
        contact.addObject("categories", categories);
        Long reviewid = contactService.getReviewId(id);
        SubmissionItem submissionItem = submission.getSubmissionbyCon(id);
        Date date = review.getDateForQ(reviewid);
        String firstName = review.getFirstName(reviewid);
        String lastName = review.getLastName(reviewid);
        contact.addObject("firstName",firstName);
        contact.addObject("lastName",lastName);
        List<questionItem> questionItems = question.getRadioQuestions(date);
        List<questionItem> getTextAreaQuestions = question.getTextAreaQuestions(date);
        contact.addObject("questionItems",questionItems);
        contact.addObject("getTextAreaQuestions",getTextAreaQuestions);
        contact.addObject("submissionItem",submissionItem);
        return contact;
    }
    @PostMapping("/form/{id}")
    public ModelAndView receiveContactAnswer(@PathVariable Long id,@RequestParam("questionAnswers") String answers){

        receiveAnswer(id,answers);


        ModelAndView result = new ModelAndView("form/thankYou");
        return result;
    }

}
