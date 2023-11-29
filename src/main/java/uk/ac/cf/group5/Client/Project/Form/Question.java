package uk.ac.cf.group5.Client.Project.Form;

public class Question {
private Long id;
    private String questionText;
    private String category;

    public Question() {
    }

    public Question(Long id, String questionText, String category) {
        this.id = id;
        this.questionText = questionText;
        this.category = category;
    }

    public Long getId() {
        return id;
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

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
