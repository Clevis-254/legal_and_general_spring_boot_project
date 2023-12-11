package uk.ac.cf.group5.Client.Project.ReviewRequests;

import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

public interface ReviewRepository {


    List<ReviewItem> getReviewItems(Long userId);


    void add(RequestItem Item);
}
