package uk.ac.cf.group5.Client.Project.Reviews;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RequestItem {
    private Long id;
    /*
    @ approved
    changed it to string so that it can accomodate the cancelled function.
     */
    private String approved;
    private Long userId;
    private String firstname;

    private String secondname;
    private Date requested;

    public RequestItem() {

        this(0L,  "", 0L,"","",new Date());
    }


}
