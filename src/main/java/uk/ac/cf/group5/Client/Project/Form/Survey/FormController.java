package uk.ac.cf.group5.Client.Project.Form.Survey;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Answer.AnswerItem;
import uk.ac.cf.group5.Client.Project.Answer.AnswerService;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;
import uk.ac.cf.group5.Client.Project.Submissions.SubmissionItem;
import uk.ac.cf.group5.Client.Project.Submissions.SubmissionService;
import uk.ac.cf.group5.Client.Project.Form.contactForms.ContactQuestionService;
import uk.ac.cf.group5.Client.Project.Form.contactForms.questionItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactService;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    private  QuestionService questionService;


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
                          ReviewService reviewService, SubmissionService submissionService, AnswerService aservices) {
        this.questionService = questionService;
        this.contactService = contactService;
        this.user = service;
        this.review = reviewService;
        this.submission = submissionService;
        this.answerService = aservices;
    }

    /*
    perhaps should add an id to reference the user answering the form questions.
     */
    @GetMapping("/form/{id}/employee")
    public ModelAndView getEmployeeForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("form/employeeForm");
        List<QuestionItem> questions = questionService.getAllQuestions();
        modelAndView.addObject("questions", questions);
        return modelAndView;
    }

    @PostMapping("/form/{id}/employee")
    public String submitResponses(@PathVariable Long id) {
        return "redirect:/form/employee/{id}/contacts";
    }


    @GetMapping("/form/employee/{id}/contacts")
    public ModelAndView getEmployeeContacts(Authentication authentication, @PathVariable Long id) {
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
        contactService.save(contact, id);
        ContactItem Item = contactService.getContactItem(id);
        Long contactID = Item.getId();
        submission.add(contactID,id);
        return "redirect:/form/employee/{id}/contacts"; // Redirect to the contact form page
    }

    @GetMapping("/form/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id){
            // Delete contact by id
            contactService.delete(id);
        return "redirect:/form/employee/contacts"; // Redirect back to the contacts list
    }


    @GetMapping("/thankYou")
    public ModelAndView getThankYou() {
        ModelAndView modelAndView = new ModelAndView("form/thankYou");
        return modelAndView;
    }

    @GetMapping("/form/{id}")
    public ModelAndView sentForm(@PathVariable Long id){
        ModelAndView contact = new ModelAndView("form/contactForm");
        Date date = review.getDateForQ(id);
        List<questionItem> questionItems = question.questionItems(date);
        List<questionItem> getTextAreaQuestions = question.getTextAreaQuestions(date);
        SubmissionItem submissionItem = submission.getSubmission(id);
        contact.addObject("questionItems",questionItems);
        contact.addObject("getTextAreaQuestions",getTextAreaQuestions);
        contact.addObject("submissionItem",submissionItem);
        return contact;
    }
    @PostMapping("/form/{id}")
    public ModelAndView receiveAnswer(@PathVariable Long id,@RequestParam("questionAnswers") String answers){
       SubmissionItem submissionItem = submission.getSubmission(id);
       Long review = submissionItem.getReviewID();
        try { ObjectMapper objectMapper = new ObjectMapper();
            List<AnswerItem> answerList = objectMapper.readValue(answers,
                    new TypeReference<List<AnswerItem>>() {});
            for (AnswerItem answer : answerList) {
                answer.setSub_id(id);
                answer.setRev_id(review);
                Long questionId = answer.getQuestion_id();
                String answerText = answer.getAnswer();
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


        ModelAndView result = new ModelAndView("form/thankYou");
        return result;
    }

}
