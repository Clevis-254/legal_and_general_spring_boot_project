package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendApprovalEmail(String username, String name) {
        SimpleMailMessage message= new SimpleMailMessage();
        System.out.println("got to email");
        message.setFrom("group5superuser@gmail.com");
        message.setTo(username);
        message.setText("Hello "+ name +", Your 360 Request has been approved. Please go to your 360 page to begin.");
        message.setSubject("360 request Approved");

        mailSender.send(message);


    }
    public void sendDenyEmail(String username, String name) {
        SimpleMailMessage message= new SimpleMailMessage();
        System.out.println("got to email");
        message.setFrom("group5superuser@gmail.com");
        message.setTo(username);
        message.setText("Hello "+ name +", Sorry but your 360 Request has been denied. Please go to your 360 page to begin.");
        message.setSubject("360 request Not Approved");

        mailSender.send(message);


    }
}
