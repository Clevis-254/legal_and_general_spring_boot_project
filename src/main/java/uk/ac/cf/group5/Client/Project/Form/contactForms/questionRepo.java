package uk.ac.cf.group5.Client.Project.Form.contactForms;


import java.sql.Date;
import java.util.List;

public interface questionRepo {

    List<questionItem> getTextAreaQuestions(Date date);

    List<questionItem> getRadioQuestions(Date date);
}
