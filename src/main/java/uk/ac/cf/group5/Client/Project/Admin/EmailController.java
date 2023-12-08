package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

@Controller
public class EmailController {
    private EmailImpl EmailImpl;
    private UserService user;
    @Autowired
    private EmailService emailService;

    @GetMapping("Admin/ApproveEmail/{userid}")
    public String sendApprovalEmail(@PathVariable("userid") long id) {
        UserItem User = user.getItem(id);
        String Username = User.getUsername();
        String name = User.getName();
        emailService.sendApprovalEmail(Username, name);
        return "redirect:/Admin/ViewRequests";
    }

    @GetMapping("Admin/DenyEmail/{userid}")
    public String sendDenyEmail(@PathVariable("userid") long id) {
        UserItem User = user.getItem(id);
        String Username = User.getUsername();
        String name = User.getName();
        emailService.sendDenyEmail(Username, name);
        return "redirect:/Admin/ViewRequests";
    }
}