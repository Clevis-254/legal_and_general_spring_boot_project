package uk.ac.cf.group5.Client.Project.Submissions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SubmissionItem {

    private Long id;

    private Long contactID;

    private Long reviewID;

    private Long userID;

//    private Map<Long,String> answers;
//new HashMap()

    public SubmissionItem(){
        this(0L,0L,0L,0L);
    }

//    public void addAnswer(Long questionId, String answerText){
//        answers.put(questionId,answerText);
//    }


}
