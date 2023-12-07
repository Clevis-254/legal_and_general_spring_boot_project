package uk.ac.cf.group5.Client.Project.contactForms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class questionItem {
    private Long id;

    private String question;

    private  String category;

    public questionItem(){
        this(0L,"","");
    }
}


