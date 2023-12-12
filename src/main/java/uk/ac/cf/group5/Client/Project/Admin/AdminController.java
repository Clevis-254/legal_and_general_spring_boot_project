package uk.ac.cf.group5.Client.Project.Admin;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.util.List;

@Controller
public class AdminController {

    private UserService user;

    public AdminController(UserService userService){
        this.user = userService;
    }

    @GetMapping ("Admin/AdminMenu")
    public ModelAndView Admin(){
        ModelAndView adminMenu = new ModelAndView("Admin/AdminMenu");
        return adminMenu;
    }
    @GetMapping("Admin/AdminSettings")
    public ModelAndView AdminSettings(Authentication authentication){
        ModelAndView settings = new ModelAndView("Admin/AdminSettings");
        String username = authentication.getName();
        UserItem userItem = user.getUserItem(username);
        settings.addObject("UserItem", userItem);
        return settings;
    }

    @PostMapping("Admin/AdminSettings")
    public ModelAndView editAdmin(@Valid UserItem userItem, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Admin/AdminSettings"
                    ,model.asMap());
            return modelAndView;
        } else {
            UserItem newUser = new UserItem(userItem.getId(),userItem.getFirstname(), userItem.getSecondname(),userItem.getUsername()
                    ,userItem.getPassword(), userItem.getRole());
            user.add(newUser);
            ModelAndView modelAndView = new ModelAndView("redirect:/Admin/AdminSettings");
            return modelAndView;
        }
    }

    @GetMapping("Admin/users")
    public ModelAndView allUsers(){
        ModelAndView users = new ModelAndView("Admin/Members");
        List<UserItem> UserItems = user.getUserItems();
        users.addObject("UserItems",UserItems);
        return users;
    }
    @GetMapping("Admin/add")
    public ModelAndView addUser(){
        ModelAndView add = new ModelAndView("Admin/add");
        UserItem newUser = new UserItem();
        add.addObject("newUser",newUser);
        return add;
    }
    @PostMapping("Admin/add")
    public  ModelAndView receiveUser(@Valid UserItem userItem, BindingResult Result, Model model){
        if (Result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Admin/add"
                    ,model.asMap());
            return modelAndView;
        } else {
            UserItem newUser = new UserItem(userItem.getId(),userItem.getFirstname(), userItem.getSecondname(),userItem.getUsername()
                    ,userItem.getPassword(), userItem.getRole());
            user.add(newUser);
            ModelAndView modelAndView = new ModelAndView("redirect:/Admin/users");
            return modelAndView;
        }
    }
}
