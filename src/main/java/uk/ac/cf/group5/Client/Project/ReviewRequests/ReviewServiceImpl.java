package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository){
        this.repository = repository;
    }
    @Override
    public void add(RequestItem review) {
        repository.add(review);
    }

    @Override
    public List<ReviewItem> getReviewItems(Long userId) {
       return repository.getReviewItems(userId);
    }
}
