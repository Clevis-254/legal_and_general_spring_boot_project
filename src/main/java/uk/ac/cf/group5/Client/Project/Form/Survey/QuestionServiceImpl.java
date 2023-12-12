
package uk.ac.cf.group5.Client.Project.Form.Survey;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionItem;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionRepository;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionService;

import java.sql.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<QuestionItem> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<QuestionItem> getTextAreaQuestions(Date date){
        return questionRepository.findTextAreaQuestions(date);
    }

    public List<QuestionItem> getRadioQuestions(Date date){
        return questionRepository.findRadioQuestions(date);
    }
}
