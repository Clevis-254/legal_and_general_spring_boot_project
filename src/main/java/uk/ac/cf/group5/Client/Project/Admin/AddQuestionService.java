package uk.ac.cf.group5.Client.Project.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddQuestionService {

    @Autowired
    private AddQuestionRepository addQuestionRepository;

    public void saveQuestion(Question question) {
        // Set the current date and time before saving
        question.setDateAdded(new Date());
        addQuestionRepository.saveQuestion(question);
    }

    public List<Question> getAllQuestions() {
        return addQuestionRepository.getAllQuestions();
    }

    public List<Question> getCurrentQuestions() {
        return addQuestionRepository.getCurrentQuestions();
    }
}