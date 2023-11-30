package uk.ac.cf.group5.Client.Project.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/403")
    public String error403() {
        return "base";
    }
}
