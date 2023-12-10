package uk.ac.cf.group5.Client.Project.Admin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import uk.ac.cf.group5.Client.Project.TestConfig;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Import(TestConfig.class)
@WebMvcTest(EmailController.class)
@ExtendWith(MockitoExtension.class)
public class EmailAppTest {

    @MockBean
    private UserService userService;  // using @MockBean to mock the UserService

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sendApprovalEmail_shouldSendEmailAndRedirect() throws Exception {
        // Mock of userService.getItem(id)
        UserItem mockedUser = new UserItem();
        mockedUser.setUsername("testuser");
        mockedUser.setName("Test User");
        when(userService.getItem(anyLong())).thenReturn(mockedUser);

        // Perform request and verify result
        mockMvc.perform(get("/Admin/ApproveEmail/{userid}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Admin/ViewRequests"));

        // Verify userService.getItem(id) called with correct argument
        verify(userService).getItem(1L);

        // Verify emailService.sendApprovalEmail called with correct arguments
        verify(emailService).sendApprovalEmail("testuser", "Test User");
    }
}