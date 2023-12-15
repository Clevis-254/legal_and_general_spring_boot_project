package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.sql.Date;
import java.util.List;


public interface ReviewService {

    void add(Long userID, Long RequestID);

    ReviewItem getReview(long userId);

    Date getDateForQ(long id);

    List<ReviewItem> getReviewItems(Long userId);

    ReviewItem getItem(long reviewID);

    String getFirstName(long reviewID);

    String getLastName(long reviewID);
}

