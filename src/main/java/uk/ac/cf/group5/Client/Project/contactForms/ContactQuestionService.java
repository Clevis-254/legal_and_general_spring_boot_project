package uk.ac.cf.group5.Client.Project.contactForms;

import java.util.List;

public interface ContactQuestionService {

    List<questionItem> questionItems();

    List<questionItem> getTextAreaQuestions();
}
