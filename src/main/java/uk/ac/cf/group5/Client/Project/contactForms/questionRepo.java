package uk.ac.cf.group5.Client.Project.contactForms;

import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.UserForm.Question;

import java.util.List;

public interface questionRepo {

    List<questionItem> questionItems();

    List<questionItem> getTextAreaQuestions();
}
