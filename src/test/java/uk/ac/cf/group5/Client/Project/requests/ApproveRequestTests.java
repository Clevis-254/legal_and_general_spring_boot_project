package uk.ac.cf.group5.Client.Project.requests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.ac.cf.group5.Client.Project.Admin.ViewRequestsImpl;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.Reviews.RequestRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApproveRequestTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RequestRepository repository;

/*    @Autowired
    private ViewRequestsImpl viewRequestsImpl;*/

    @Test
    @WithMockUser(username = "James", roles = "ADMIN")
    public void shouldApprovePendingRequest() throws Exception {

        //GIVEN REQUEST 1 IS IN THE DATABASE AND IS PENDING

        //WHEN REQUEST 1 IS APPROVED
        mvc.perform(MockMvcRequestBuilders.get("/Admin/approve/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Admin/ViewPendingRequests"));

        //AND REQUEST 1 IS THEN RETRIEVED
        RequestItem updatedRequest = repository.getRequestItems(1L).get(0);

        System.out.println("Request 1 after approval: " + updatedRequest);

        //THEN REQUEST 1 SHOULD BE APPROVED
        assertEquals("approved", updatedRequest.getApproved());

    }


}
