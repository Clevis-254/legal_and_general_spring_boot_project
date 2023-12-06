package uk.ac.cf.group5.Client.Project.Form;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactForm;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactsRepository;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionItem;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionService;

import java.util.List;

@Controller
public class FormController {

    private final QuestionService questionService;

    public FormController(QuestionService questionService) {
        this.questionService = questionService;
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
        List<ContactItem> contacts = null;
        modelAndView.addObject("contacts", null);
        return modelAndView;
    }

    @PostMapping("/form/employee/contacts")
    public String addContacts(@RequestBody List<ContactItem> contacts) {
        // Process the received contacts here (e.g., save to a database)
        for (ContactItem contact : contacts) {
            ContactForm contactForm = new ContactForm();
            contactForm.setName(contact.getName());
            contactForm.setEmail(contact.getEmail());
            contactForm.setCategory(contact.getCategory());
            // Save contacts to a database
            ContactsRepository contactsRepository = new ContactsRepository();
            contactsRepository.addContact(contactForm);
        }
        // Example: printing received contacts to the console
        for (ContactItem contact : contacts) {
            System.out.println(contact.toString());
            // Save contacts to a database or perform necessary operations
        }

        // Return a success message or any response if needed
    return "redirect:/form/thankYou";
}

    @GetMapping("/thankYou")
    public ModelAndView getThankYou() {
        ModelAndView modelAndView = new ModelAndView("form/thankYou");
        return modelAndView;
    }
}
