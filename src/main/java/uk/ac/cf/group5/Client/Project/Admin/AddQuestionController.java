package uk.ac.cf.group5.Client.Project.Admin;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.List;

@Controller
public class AddQuestionController {

    @Autowired
    private AddQuestionService addQuestionService;

    @GetMapping("/Admin/AddQuestions")
    public ModelAndView showAddQuestionForm(Model model) {
        List<Question> allQuestions = addQuestionService.getAllQuestions();
        List<Question> currentQuestions = addQuestionService.getCurrentQuestions();

        ModelAndView modelAndView = new ModelAndView("/admin/AddQuestions");
        modelAndView.addObject("allQuestions", allQuestions);
        modelAndView.addObject("currentQuestions", currentQuestions);

        return modelAndView;
    }

    @PostMapping("/Admin/AddQuestions")
    public String addQuestion(@ModelAttribute Question question) {
        addQuestionService.saveQuestion(question);
        return "redirect:/Admin/AddQuestions";
    }

    @GetMapping("/Admin/AllQuestions")
    public ModelAndView showAllQuestions(Model model) {
        List<Question> allQuestions = addQuestionService.getAllQuestions();
        ModelAndView modelAndView = new ModelAndView("/admin/AllQuestions");
        modelAndView.addObject("allQuestions", allQuestions);
        return modelAndView;
    }

    @GetMapping("/Admin/CurrentQuestions")
    public ModelAndView showCurrentQuestions(Model model) {
        List<Question> currentQuestions = addQuestionService.getCurrentQuestions();
        ModelAndView modelAndView = new ModelAndView("/admin/CurrentQuestions");
        modelAndView.addObject("currentQuestions", currentQuestions);
        return modelAndView;
    }
}