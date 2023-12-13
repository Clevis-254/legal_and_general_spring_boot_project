
package uk.ac.cf.group5.Client.Project.Form.employeeForms;


public class Response {
    private Long responseID;
    private Long userID;
    private Integer answer1;
    private Integer answer2;
    private Integer answer3;
    private Integer answer4;

    // Constructors, getters, and setters
    public Response() {
    }

    public Response(Long responseID, Long userID, Integer answer1, Integer answer2, Integer answer3, Integer answer4){
        this.responseID = responseID;
        this.userID = userID;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public Long getResponseID() {
        return responseID;
    }

    public Long getUserID() {
        return userID;
    }

    public Integer getAnswer1() {
        return answer1;
    }

    public Integer getAnswer2() {
        return answer2;
    }

    public Integer getAnswer3() {
        return answer3;
    }

    public Integer getAnswer4() {
        return answer4;
    }
    public void setResponseID(Long responseID) {
        this.responseID = responseID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setAnswer1(Integer answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(Integer answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(Integer answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(Integer answer4) {
        this.answer4 = answer4;
    }


}

