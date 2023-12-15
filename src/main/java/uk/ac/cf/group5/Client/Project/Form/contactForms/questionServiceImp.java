package uk.ac.cf.group5.Client.Project.Form.contactForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class questionServiceImp implements ContactQuestionService {
    @Autowired
    private questionRepo Repository;

    public questionServiceImp (questionRepo repository){
        this.Repository = repository;
    }


     public List<questionItem> getTextAreaQuestions(Date date){
         return Repository.getTextAreaQuestions(date);
    }

    public List<questionItem> getRadioQuestions(Date date){
        return Repository.getRadioQuestions(date);
    }

}
