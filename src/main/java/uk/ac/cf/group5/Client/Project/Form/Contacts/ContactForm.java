package uk.ac.cf.group5.Client.Project.Form.Contacts;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ContactForm {

    private long id;
    @NotEmpty(message = "Please enter a user id")
    private long userId;
    @NotEmpty(message = "Please enter a name")
    private String name;
    @NotEmpty(message = "Please enter an email")
    private String email;
    private Integer category;

    public ContactForm() {
        this(0, 0, "", "", 0);
    }



}
