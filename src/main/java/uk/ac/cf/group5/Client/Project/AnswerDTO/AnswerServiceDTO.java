package uk.ac.cf.group5.Client.Project.AnswerDTO;

import java.util.List;

public interface AnswerServiceDTO {
    List<AnswerDTO> getAnswersGroupedByCategory();

    List<AnswerDTO> getAnswersGroupedByContact();
}
