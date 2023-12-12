package uk.ac.cf.group5.Client.Project.Admin;

import java.util.Date;

public class Question {

    private int id; // Assuming you have an id field in your questions table
    private int questionNumber;
    private String questionText;
    private String contactQuestionText;
    private Date dateAdded;
    private String category;

    // Constructors

    public Question() {
        // Default constructor
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getContactQuestionText() {
        return contactQuestionText;
    }

    public void setContactQuestionText(String contactQuestionText) {
        this.contactQuestionText = contactQuestionText;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
