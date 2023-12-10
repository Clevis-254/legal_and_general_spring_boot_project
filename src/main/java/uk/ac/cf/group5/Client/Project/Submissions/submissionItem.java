package uk.ac.cf.group5.Client.Project.Submissions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class submissionItem {

    private Long id;

    private Long userID;

    private Long requestID;

    public submissionItem(){
        this(0L,0L,0L);
    }
}
