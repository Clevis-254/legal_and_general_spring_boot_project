package uk.ac.cf.group5.Client.Project.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mail.javamail.JavaMailSender;
import uk.ac.cf.group5.Client.Project.Admin.EmailController;
import uk.ac.cf.group5.Client.Project.Admin.EmailService;
import uk.ac.cf.group5.Client.Project.TestConfig;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(TestConfig.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class EmailAppTest {

    @MockBean
    private UserService userService;

    @MockBean
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "notareal@gmail.com", roles = "ADMIN")
    void sendApprovalEmail_shouldSendEmailAndRedirect() throws Exception {
        // Mock of userService.getItem(id)
        UserItem mockedUser = new UserItem();
        mockedUser.setUsername("testuser");
        mockedUser.setFirstname("Test User");
        when(userService.getItem(anyLong())).thenReturn(mockedUser);

        //when(emailService.sendApprovalEmail(anyString(),anyString())).;)

        // redirect back to review request page
        mockMvc.perform(get("/Admin/ApproveEmail/{userid}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Admin/ViewRequests"));

        // Verify userService.getItem(id) with correct arg
        verify(userService).getItem(1L);

        // Verify emailService.sendApprovalEmail with correct arg
        verify(emailService).sendApprovalEmail("testuser", "Test User");
    }
    @Test
    @WithMockUser(username = "notareal@gmail.com", roles = "ADMIN")
    void sendDenyEmail_shouldSendEmailAndRedirect() throws Exception {
        // Mock of userService.getItem(id)
        UserItem mockedUser = new UserItem();
        mockedUser.setUsername("testuser");
        mockedUser.setFirstname("Test User");
        when(userService.getItem(anyLong())).thenReturn(mockedUser);

        //when(emailService.sendDenyEmail(anyString(),anyString())).;)

        // redirect back to review request page
        mockMvc.perform(get("/Admin/DenyEmail/{userid}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Admin/ViewRequests"));

        // Verify userService.getItem(id) with correct arg
        verify(userService).getItem(1L);

        // Verify emailService.sendApprovalEmail with correct arg
        verify(emailService).sendDenyEmail("testuser", "Test User");
    }
}