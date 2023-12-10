package uk.ac.cf.group5.Client.Project.Answer;

import org.springframework.stereotype.Service;

@Service
public class AnswerServiceimpl implements AnswerService{

    private AnswerRepo answerRepo;

    @Override
    public void add(AnswerItem answerItem) {
        answerRepo.add(answerItem);
    }
}
