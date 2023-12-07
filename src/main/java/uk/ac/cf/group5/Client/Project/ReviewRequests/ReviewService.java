package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    public List<ReviewItem> getInProgressReviews(Long userId) {
        return ReviewRepository.findByRequestIdAndStatus("requestId", "in progress");
    }

}
