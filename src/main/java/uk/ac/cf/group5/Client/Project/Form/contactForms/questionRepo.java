package uk.ac.cf.group5.Client.Project.contactForms;

import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;


import java.sql.Date;
import java.util.List;

public interface questionRepo {

    List<questionItem> questionItems(Date date);

    List<questionItem> getTextAreaQuestions(Date date);
}
