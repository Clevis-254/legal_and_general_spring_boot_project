package uk.ac.cf.group5.Client.Project.Reviews;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RequestItem {
    private Long id;
    private Boolean approved; // Updated field name to follow Java naming conventions
    private Long userId;
    private String username;

    private Date requested;

    public RequestItem() {
        this(0L,  false, 0L,"",new Date());
    }
}
