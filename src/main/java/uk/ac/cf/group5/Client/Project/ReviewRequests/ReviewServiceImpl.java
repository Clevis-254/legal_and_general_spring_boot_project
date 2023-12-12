package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.user.UserItem;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository){
        this.repository = repository;
    }
    @Override
    public void add(Long userID, Long RequestID) {
        repository.add( userID, RequestID);
    }

    @Override
    public List<ReviewItem> getReviewItems(Long userId) {
       return repository.getReviewItems(userId);
    }

    public ReviewItem getReview(long userId) {
        return repository.getReview(userId);
    }
    public ReviewItem getItem(long reviewID) {
        return repository.getItem(reviewID);
    }
}
