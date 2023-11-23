package uk.ac.cf.group5.Client.Project.Reviews;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestItem {
    private Long id;
    private String username;
    private Boolean approved; // Updated field name to follow Java naming conventions
    private Long userId;

    public RequestItem() {
        this(0L, "", false, 0L);
    }
}
