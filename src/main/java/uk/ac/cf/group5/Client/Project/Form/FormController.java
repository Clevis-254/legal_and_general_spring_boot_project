package uk.ac.cf.group5.Client.Project.Form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactRepositoryImpl;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactService;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionItem;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionService;

import java.util.List;

@Controller
public class FormController {

    private final QuestionService questionService;
    private final ContactService contactService;
    public FormController(QuestionService questionService, ContactService contactService) {
        this.questionService = questionService;
        this.contactService = contactService;
    }

    @GetMapping("/form/employee")
    public ModelAndView getEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("form/employeeForm");
        List<QuestionItem> questions = questionService.getAllQuestions();
        modelAndView.addObject("questions", questions);
        return modelAndView;
    }

    @PostMapping("/form/employee")
    public String submitResponses() {
        return "redirect:/form/employee/contacts";
    }


    @GetMapping("/form/employee/contacts")
    public ModelAndView getEmployeeContacts() {
        ModelAndView modelAndView = new ModelAndView("form/contacts");
        modelAndView.addObject("reviewID", 1); // TODO: replace with actual review ID
        modelAndView.addObject("contact", new ContactItem());
        List<ContactItem> contacts = contactService.getContactItems(1); // Fetch contacts from the database
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @PostMapping("/form/addContact")
    public String addContact(@ModelAttribute ContactItem contact) {
        // Process and save the received contact to the database
        System.out.println(contact.toString());
        contactService.save(contact, 1); // TODO: Replace with actual result ID
        return "redirect:/form/employee/contacts"; // Redirect to the contact form page
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
}
