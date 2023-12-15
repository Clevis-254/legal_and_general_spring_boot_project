package uk.ac.cf.group5.Client.Project.AnswerDTO;

import java.util.List;

public interface AnswerRepositoryDTO {
    List<AnswerDTO> getAnswersGroupedByCategory();

    List<AnswerDTO> getAnswersGroupedByContact();

    List<AnswerDTO> getAnswersForSubmission(Long submissionId);
}
