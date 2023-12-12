
package uk.ac.cf.group5.Client.Project.Form.Survey;

import java.sql.Date;

public class QuestionItem {
    private Long id;
    private int questionNum;
    private String questionUserText;
    private Date date;
    private  String category;

    public QuestionItem() {
    }

    public QuestionItem(Long id, int questionNum, String questionUserText, String category) {
        this.id = id;
        this.questionNum = questionNum;
        this.questionUserText = questionUserText;
        this.category = category;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionUserText;
    }

    public int getQuestionNum(){return questionNum;}

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
