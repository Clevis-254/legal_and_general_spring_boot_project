package uk.ac.cf.group5.Client.Project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@ComponentScan(basePackages = {"uk.ac.cf.group5.Client.Project.ReviewRequests"})
@Configuration
public class TestConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }
}

