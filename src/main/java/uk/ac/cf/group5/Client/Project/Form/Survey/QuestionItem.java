
package uk.ac.cf.group5.Client.Project.Form.Survey;
public class QuestionItem {
private Long id;
    private String questionText;
    private String category;

    private Integer question_num;

    public QuestionItem() {
    }

    public QuestionItem(Long id, String questionText, String category, Integer question_num) {
        this.id = id;
        this.questionText = questionText;
        this.category = category;
        this.question_num = question_num;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuestion_num() {
        return question_num;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion_num(Integer question_num) {
        this.question_num = question_num;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
