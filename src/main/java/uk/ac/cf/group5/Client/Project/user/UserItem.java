package uk.ac.cf.group5.Client.Project.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserItem {
    private Long id;
    private String username;

    private  String email;

    private String password;

    public UserItem(){
        this(0L,"","","");
    }

}
