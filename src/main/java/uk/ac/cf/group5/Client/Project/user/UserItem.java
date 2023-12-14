package uk.ac.cf.group5.Client.Project.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserItem {
    private Long id;
    private String firstname;

    private String secondname;
    private  String username;

    private String password;

    private String role;


    public UserItem (){

        this(0L,"","","","","");
    }

//    public boolean isNew() {
//
//        return this.username == null;
//    }

}
