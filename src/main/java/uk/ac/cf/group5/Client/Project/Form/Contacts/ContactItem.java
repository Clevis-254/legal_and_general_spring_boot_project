package uk.ac.cf.group5.Client.Project.Form.Contacts;



public class ContactItem {
    private Long id;
    private Long reviewsId;
    private String firstName;
    private String lastName;
    private String email;
    private String category;

    public ContactItem() {
    }

    public ContactItem(Long id, Long reviewsID, String firstName, String lastName , String email, String category) {
        this.id = id;
        this.reviewsId = reviewsID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.category = category;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Long getReviewsId(){return reviewsId;}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

   public String getCategory(){
        return category;}

    public Long getResultID() {
        return reviewsId;
    }

    // Setters
    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setResultID(long resultID) {
        this.reviewsId = resultID;
    }
}
