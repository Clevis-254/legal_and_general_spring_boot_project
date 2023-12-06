package uk.ac.cf.group5.Client.Project.Form.Contacts;

public class ContactItem {

    private Long id;
    private String name;
    private String email;
    private Integer category;

    public ContactItem() {
    }

    public ContactItem(Long id, String name, String email, Integer category) {
        this.name = name;
        this.email = email;
        this.category = category;
    }

    // Getters

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

   public Integer getCategory(){
        return category;}


    public String getCategoryName(){
        if (category == 1){
            return "Manager";
        }
        else if (category == 2){
            return "Team Member";
        }
        else if (category == 3){
            return "External Contact";
        }
        else{
            return "Unknown";
        }
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
