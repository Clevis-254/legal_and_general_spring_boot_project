package uk.ac.cf.group5.Client.Project.ReviewRequests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class ReviewItem {

    private Long id;
    private Long userId;
    private Long requestId;
    private String status;
    private Date date_started;

    public ReviewItem() {
        this(0L, 0L, 0L, "", new Date(System.currentTimeMillis()));
    }
}
