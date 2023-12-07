package uk.ac.cf.group5.Client.Project.UserForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.contactForms.ContactQuestionService;
import uk.ac.cf.group5.Client.Project.contactForms.questionItem;

import java.awt.*;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    private final QuestionService questionService;

    @Autowired
    private ContactQuestionService question;

    public FormController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /*
    perhaps should add an id to reference the user answering the form questions.
     */
    @GetMapping("/form/employee")
    public ModelAndView getEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("form/employeeForm");
        List<Question> questions = questionService.getAllQuestions();
        modelAndView.addObject("questions", questions);
        return modelAndView;
    }

    @PostMapping("/form/employee")
    public String submitResponses() {
        return "redirect:/thankYou";
    }

    @GetMapping("/thankYou")
    public ModelAndView getThankYou() {
        ModelAndView modelAndView = new ModelAndView("form/thankYou");
        return modelAndView;
    }

    @GetMapping("/form/other")
    public ModelAndView sentForm(){
        ModelAndView contact = new ModelAndView("form/contactForm");
        List<questionItem> questionItems = question.questionItems();
        List<questionItem> getTextAreaQuestions = question.getTextAreaQuestions();
        contact.addObject("questionItems",questionItems);
        contact.addObject("getTextAreaQuestions",getTextAreaQuestions);
        return contact;
    }
}
