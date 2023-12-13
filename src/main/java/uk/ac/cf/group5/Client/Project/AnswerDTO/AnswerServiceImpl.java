package uk.ac.cf.group5.Client.Project.AnswerDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerServiceDTO {
    private final AnswerRepositoryDTO answerRepository;


    public AnswerServiceImpl(AnswerRepositoryDTO Repository) {
        this.answerRepository = Repository;
    }

    @Override
    public List<AnswerDTO> getAnswersGroupedByCategory() {
        return answerRepository.getAnswersGroupedByCategory();
    }
    @Override
    public   List<AnswerDTO> getAnswersGroupedByContact(){
        return answerRepository.getAnswersGroupedByContact();
    }

    @Override
    public  List<AnswerDTO> getAnswersForSubmission(Long submissionId){
        return answerRepository.getAnswersForSubmission(submissionId);
    }
}
