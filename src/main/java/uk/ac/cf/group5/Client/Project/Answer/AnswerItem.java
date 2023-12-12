package uk.ac.cf.group5.Client.Project.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AnswerItem {
    private Long id;

    private Long question_id;

    private Long sub_id;
    private String answer;

    public  AnswerItem(){

        this(0L,0L,0L,"");
    }
}
