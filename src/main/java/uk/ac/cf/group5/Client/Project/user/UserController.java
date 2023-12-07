package uk.ac.cf.group5.Client.Project.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
   private UserService user;

    public  UserController( UserService userService){
        this.user = userService;
    }


    @GetMapping("/login")
    public ModelAndView Login(){
        ModelAndView login = new ModelAndView("/LoginPage");
        return login;
    }

//    @GetMapping("/LoginSuccess")
//    public void LoginSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
//            throws Exception, ServletException {
//        String role = authResult.getAuthorities().toString();
//
//
//        if(role.contains("ROLE_ADMIN")){
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/Admin/AdminMenu"));
//        }
//        else if(role.contains("ROLE_USER")){
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/dashboard"));
//
//        }
//        else {response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/login"));
//
//        }
//    }

    @GetMapping("/settings")
    public ModelAndView settings(Authentication authentication){
        ModelAndView settings = new ModelAndView("/settings");
        String username = authentication.getName();
        UserItem userItem = user.getUserItem(username);
        settings.addObject("UserItem", userItem);
        return settings;
    }

    @PostMapping("/settings")
    public ModelAndView edit(@Valid UserItem userItem, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/settings"
                    ,model.asMap());
           return modelAndView;
        } else {
            UserItem newUser = new UserItem(userItem.getId(),userItem.getName(),userItem.getUsername()
                                ,userItem.getPassword());
            user.add(newUser);
            ModelAndView modelAndView = new ModelAndView("redirect:/settings");
            return modelAndView;
        }
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
    @GetMapping("/LoginSuccess")
    public void LoginSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws Exception, ServletException {
        String role = authResult.getAuthorities().toString();

        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/Admin/AdminMenu"));
        }
        else if(role.contains("ROLE_USER")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/dashboard"));

        }
        else {response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/login"));

        }
    }

}
