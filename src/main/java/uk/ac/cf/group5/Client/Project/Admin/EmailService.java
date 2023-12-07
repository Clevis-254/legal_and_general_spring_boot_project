package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.beans.

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("group5superuser@gmail.com");
        message.setText(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        System.out.println("approval Email sent");


    }
}
