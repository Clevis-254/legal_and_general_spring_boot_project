package uk.ac.cf.group5.Client.Project.Form.contactForms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class questionItem {
    private Long id;

    private String question;

    private Integer question_num;

    private  String category;

    public questionItem(){
        this(0L,"",0, "");
    }
}


