package uk.ac.cf.group5.Client.Project.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserItem {
    private Long id;
    private String name;

    private  String username;

    private String password;

    private String role;

    public UserItem(){
        this(0L,"","","","");
    }

}
