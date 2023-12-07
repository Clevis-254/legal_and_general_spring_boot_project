package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    public class EmailController {

        @Autowired
        private EmailService emailService;

        @GetMapping("/send-email")
        public String sendEmail() {


            emailService.sendEmail(to, subject, body);

            // Redirect to a confirmation page or handle as needed
            return "email-sent-success";
        }
        @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
            senderService.send
        }
}
