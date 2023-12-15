package uk.ac.cf.group5.Client.Project.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewRepoImp;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewRepoImpTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ReviewRepoImp reviewRepo;

    @Test
    void getReviewItems() {
        // Given
        long userId = 1L;

        List<ReviewItem> expectedReviewItems = Collections.singletonList(
                new ReviewItem(1L, userId, 2L, "in_progress", Date.valueOf("2023-05-01"))
        );
        when(jdbcTemplate.query(any(String.class), any(RowMapper.class), any(Long.class)))
                .thenReturn(expectedReviewItems);

        // When
        List<ReviewItem> actualReviewItems = reviewRepo.getReviewItems(userId);

        // Then
        assertEquals(expectedReviewItems, actualReviewItems,
                "Review items should be retrieved as expected");
    }
}