package uk.ac.cf.group5.Client.Project.Form.Survey;

import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionItem;

import java.sql.Date;
import java.util.List;

public interface QuestionRepository {
    List<QuestionItem> findAll();

    List<QuestionItem> findTextAreaQuestions(Date date);

    List<QuestionItem> findRadioQuestions(Date date);
}
