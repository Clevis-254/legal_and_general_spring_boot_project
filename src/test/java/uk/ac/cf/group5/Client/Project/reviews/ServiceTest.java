package uk.ac.cf.group5.Client.Project.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewRepository;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ReviewServiceImplTest {

    @Mock
    private ReviewRepository repository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Test
    void getReviewItems() {
        // Given
        Long userId = 1L;
        List<ReviewItem> expectedReviewItems = Collections.singletonList(new ReviewItem(1L, userId, 2L, "in_progress", null));

        when(repository.getReviewItems(userId)).thenReturn(expectedReviewItems);

        // When
        List<ReviewItem> actualReviewItems = reviewService.getReviewItems(userId);

        // Then
        verify(repository, times(1)).getReviewItems(userId);
        assertEquals(expectedReviewItems, actualReviewItems, "Review items should be retrieved as expected");
    }
}