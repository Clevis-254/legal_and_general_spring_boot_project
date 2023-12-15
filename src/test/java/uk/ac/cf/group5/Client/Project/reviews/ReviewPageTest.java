package uk.ac.cf.group5.Client.Project.reviews;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;
import uk.ac.cf.group5.Client.Project.Reviews.RequestController;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewPageTest {

    @Mock
    private ReviewService reviewService;

    @Mock
    private UserService userService;

    @InjectMocks
    private RequestController requestController;

    @Test
    public void ReturnReviewsPage() {
        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn("testUser");
        UserItem testUserItem = new UserItem();
        when(userService.getUserItem("testUser")).thenReturn(testUserItem);

        List<ReviewItem> mockReviewItems = Collections.singletonList(new ReviewItem());
        when(reviewService.getReviewItems(anyLong())).thenReturn(mockReviewItems);

        ModelAndView result = requestController.getReviews(authentication);

        assertEquals("360's/Reviews", result.getViewName());
        assertEquals(mockReviewItems, result.getModel().get("reviewItems"));
        verify(userService).getUserItem("testUser");
        verify(reviewService).getReviewItems(anyLong());
    }
}