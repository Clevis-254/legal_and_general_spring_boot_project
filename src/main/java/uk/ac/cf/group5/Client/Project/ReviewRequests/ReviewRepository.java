package uk.ac.cf.group5.Client.Project.ReviewRequests;

import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.sql.Date;
import java.util.List;

public interface ReviewRepository {


    List<ReviewItem> getReviewItems(long userId);

    ReviewItem getReview(long userId);

    Date getDateForQ(long reviewId);
    void add(Long userID, Long RequestID);
    ReviewItem getItem(long reviewID);
}
