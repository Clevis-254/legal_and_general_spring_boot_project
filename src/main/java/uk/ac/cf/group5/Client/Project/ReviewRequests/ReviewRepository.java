package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository {


    static List<ReviewItem> findByRequestIdAndStatus(String requestId, String inProgress) {
        return null;
    }

    void add(Long Id);
}
