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

    private Long requestID;

    private Map<Long,String> answers;


    public submissionItem(){
        this(0L,0L,0L,new HashMap());
    }

    public void addAnswer(Long questionId, String answerText){
        answers.put(questionId,answerText);
    }


}
