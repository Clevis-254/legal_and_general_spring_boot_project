package uk.ac.cf.group5.Client.Project.Form.contactForms;

import java.sql.Date;
import java.util.List;

public interface ContactQuestionService {

    List<questionItem> questionItems(Date date);

    List<questionItem> getTextAreaQuestions(Date date);
}
