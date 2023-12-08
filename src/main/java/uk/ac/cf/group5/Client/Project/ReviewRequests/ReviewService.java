package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    void add(ReviewItem review);

    List<ReviewItem> getReviewItems(Long userId);
}

