package uk.ac.cf.group5.Client.Project.Form.contactForms;


import java.util.List;

public interface questionRepo {

    List<questionItem> questionItems();

    List<questionItem> getTextAreaQuestions();
}
