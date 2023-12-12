package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddQuestionsController {
    @GetMapping("/Admin/AddQuestions")
    public ModelAndView getAddQuestions() {
        ModelAndView addquestions = new ModelAndView("Admin/AddQuestions");
        return addquestions;
    }
}
