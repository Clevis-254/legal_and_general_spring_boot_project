package uk.ac.cf.group5.Client.Project.AnswerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AnswerDTO {
    private String category;
    private Long answerId;
    private String answer;
    private Long questionId;

    private List<AnswerDTO> answers;
    public AnswerDTO(){
        this("",0L,"",0L,new ArrayList<>());
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
