package uk.ac.cf.group5.Client.Project.Form.Contacts.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class ContactEmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String username, String Contactname, String Empname, Long link) {
        SimpleMailMessage message= new SimpleMailMessage();
        System.out.println("got to contact email");
        message.setFrom("group5superuser@gmail.com");
        message.setTo(username);
        message.setText("Hello "+ Contactname +", You have been asked to participate in "+ Empname +"'s 360. Please go to this link to begin: http://localhost:8080/form/"+link+"/contactForm .");
        message.setSubject("360 request Approved");

        mailSender.send(message);


    }
}
