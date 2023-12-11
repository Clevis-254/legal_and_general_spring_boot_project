package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

@Service
public interface ReviewService {

    void add(RequestItem review);

    List<ReviewItem> getReviewItems(Long userId);
}

