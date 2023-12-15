
package uk.ac.cf.group5.Client.Project.Form.employeeForms;

import java.sql.Date;

public class QuestionItem {
    private Long id;
    private int questionNum;
    private String questionUserText;
    private  String category;

    public QuestionItem() {
    }

    public QuestionItem(Long id, String questionText, String category, Integer question_num) {
        this.id = id;
        this.questionNum = question_num;
        this.questionUserText = questionText;
        this.category = category;

    }

    public Long getId() {
        return id;
    }

    public Integer getQuestion_num() {
        return questionNum;
    }

    public String getQuestionText() {
        return questionUserText;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionUserText = questionText;
    }
    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
