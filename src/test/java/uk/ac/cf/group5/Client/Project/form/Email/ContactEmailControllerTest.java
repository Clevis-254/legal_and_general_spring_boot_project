//package uk.ac.cf.group5.Client.Project.form.Email;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
//import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactService;
//import uk.ac.cf.group5.Client.Project.Form.Contacts.Email.ContactEmailController;
//import uk.ac.cf.group5.Client.Project.Form.Contacts.Email.ContactEmailService;
//import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;
//import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewService;
//import uk.ac.cf.group5.Client.Project.TestConfig;
//import uk.ac.cf.group5.Client.Project.user.UserItem;
//import uk.ac.cf.group5.Client.Project.user.UserService;
//
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@Import(TestConfig.class)
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
//class ContactEmailControllerTest {
//
//    @MockBean
//    private ContactService contactService;
//
//    @MockBean
//    private ReviewService reviewService;
//
//    @MockBean
//    private ContactEmailService contactEmailService;
//
//    @MockBean
//    private UserService userService;
//
//    @InjectMocks
//    private ContactEmailController contactEmailController;
//
//    private MockMvc mockMvc;
//
//    @Test
//    void testSendContactEmail() throws Exception {
//         Mock data
//        long reviewId = 1L;
//        String empName = "John Doe";
//
//        ContactItem contactItem = new ContactItem(1L, reviewId, "John", "Doe", "john.doe@example.com", "SomeCategory");
//        when(contactService.getContactItems(reviewId)).thenReturn(Arrays.asList(contactItem));
//
//        ReviewItem reviewItem = new ReviewItem(1L, "SomeReview", reviewId);
//        when(reviewService.getItem(reviewId)).thenReturn(reviewItem);
//
//        UserItem userItem = new UserItem(1L, "John", "Doe");
//        when(userService.getItem(reviewItem.getUserId())).thenReturn(userItem);
//
//        // Perform the GET request
//        mockMvc = MockMvcBuilders.standaloneSetup(contactEmailController).build();
//        mockMvc.perform(get("/form/employee/email/{reviewId}", reviewId))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/thankYou"));
//
//        // Verify that the sendContactEmail method was called with the expected arguments
//        verify(contactEmailService, times(1)).sendContactEmail(
//                eq(contactItem.getEmail()),
//                eq(contactItem.getFirstName() + " " + contactItem.getLastName()),
//                eq(empName),
//                eq(contactItem.getId())
//        );
//    }
//}