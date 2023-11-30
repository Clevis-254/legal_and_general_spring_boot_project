package uk.ac.cf.group5.Client.Project.Form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FormController {

    private final QuestionServiceImpl questionService;

    public FormController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }



    @GetMapping("/form/employee")
    public ModelAndView getEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("form/employeeForm");
        List<Question> questions = questionService.getAllQuestions();
        modelAndView.addObject("questions", questions);
//        modelAndView.addObject("response", new Response());
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
}
