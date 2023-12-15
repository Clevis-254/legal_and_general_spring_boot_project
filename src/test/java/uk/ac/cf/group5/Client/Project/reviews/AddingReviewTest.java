package uk.ac.cf.group5.Client.Project.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewRepoImp;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class AddingReviewTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ReviewRepoImp reviewRepo;

    @Test
    void add() {
        // Create a RequestItem for testing
        RequestItem requestItem = new RequestItem();
        requestItem.setUserId(1L);
        requestItem.setId(2L);

        // Calling the method to be tested
        reviewRepo.add(requestItem);

        // Verify that the data was added to the Reviews table
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Reviews", Integer.class);
        assertEquals(1, count, "One row should be added to the Reviews table");
    }
}