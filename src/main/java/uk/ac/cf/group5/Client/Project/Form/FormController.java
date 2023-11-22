package uk.ac.cf.group5.Client.Project.Form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @GetMapping("/form/employee")
    public ModelAndView getEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("form/employeeForm");
        modelAndView.addObject("employee", new EmployeeForm());
        return modelAndView;
    }
}
