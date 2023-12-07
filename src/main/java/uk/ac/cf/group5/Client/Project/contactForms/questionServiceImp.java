package uk.ac.cf.group5.Client.Project.contactForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionServiceImp implements ContactQuestionService {
    @Autowired
    private questionRepo Repository;

    public questionServiceImp (questionRepo repository){
        this.Repository = repository;
    }

    public List<questionItem> questionItems(){
        return Repository.questionItems();
    }

     public List<questionItem> getTextAreaQuestions(){
         return Repository.getTextAreaQuestions();
    }

}
