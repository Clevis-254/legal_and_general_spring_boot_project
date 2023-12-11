package uk.ac.cf.group5.Client.Project.Submissions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class submissionItem {

    private Long id;

    private Long userID;

    private Long reviewID;

//    private Map<Long,String> answers;
//new HashMap()

    public submissionItem(){
        this(0L,0L,0L);
    }

//    public void addAnswer(Long questionId, String answerText){
//        answers.put(questionId,answerText);
//    }


}
