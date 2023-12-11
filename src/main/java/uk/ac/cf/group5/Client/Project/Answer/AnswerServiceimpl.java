package uk.ac.cf.group5.Client.Project.Answer;

import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.user.UserRepository;

@Service
public class AnswerServiceimpl implements AnswerService{

    private AnswerRepo answerRepo;

    public AnswerServiceimpl(AnswerRepo repository){
        this.answerRepo = repository;
    }

    @Override
    public void add(AnswerItem answerItem) {
        answerRepo.add(answerItem);
    }
}
