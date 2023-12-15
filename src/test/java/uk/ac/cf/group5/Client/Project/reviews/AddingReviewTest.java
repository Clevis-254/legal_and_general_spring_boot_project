//package uk.ac.cf.group5.Client.Project.reviews;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.annotation.DirtiesContext;
//import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
//import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewRepoImp;
//import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//class ReviewRepoImpTest {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private ReviewRepoImp reviewRepo;
//
//    @Test
//    void addReview() {
//
//        RequestItem requestItem = new RequestItem();
//        requestItem.setUserId(1L);
//        requestItem.setId(2L);
//
//        reviewRepo.add(requestItem.getUserId(), requestItem.getId());
//
//
//        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM reviews", Integer.class);
//        assertEquals(1, count, "One row should be added to the Reviews table");
//
//
//        List<ReviewItem> reviewItems = jdbcTemplate.query("SELECT * FROM reviews", reviewRepo.setReviewMapper());
//        assertEquals(1, reviewItems.size(), "One review item should be added");
//        ReviewItem addedReview = reviewItems.get(0);
//        assertEquals(requestItem.getUserId(), addedReview.getUserId(), "User ID should match");
//        assertEquals(requestItem.getId(), addedReview.getRequestId(), "Request ID should match");
//
//    }
//}