
package uk.ac.cf.group5.Client.Project.Form.employeeForms;
public class QuestionItem {
    private Long id;
    private int questionNum;
    private String questionUserText;
    private Date date;
    private  String category;

    public QuestionItem() {
    }

    public QuestionItem(Long id, String questionText, String category, Integer question_num, Date date) {
        this.id = id;
        this.questionNum = questionNum;
        this.questionUserText = questionUserText;
        this.category = category;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public Integer getQuestion_num() {
        return question_num;
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
