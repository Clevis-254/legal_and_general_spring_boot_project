package uk.ac.cf.group5.Client.Project.Form.employeeForms;

import java.sql.Date;
import java.util.List;

public interface QuestionService {

    List<QuestionItem> getAllQuestions();

    List<QuestionItem> getTextAreaQuestions(Date date);

    List<QuestionItem> getRadioQuestions(Date date);
}
