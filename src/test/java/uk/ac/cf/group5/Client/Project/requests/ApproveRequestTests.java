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

//@SpringBootTest
//@AutoConfigureMockMvc
//public class ApproveRequestTests {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private RequestRepository repository;
//
//    @MockBean
//    private ViewRequestsImpl viewRequestsImpl;
//
//    @Test
//    @WithMockUser(username = "James", roles = "ADMIN")
//    public void shouldApproveThreeItems() throws Exception {
//        RequestItem request1 = new RequestItem(1L, "pending", 1L, "dave", new Date());
//        RequestItem request2 = new RequestItem(2L, "pending", 1L, "dave", new Date());
//        RequestItem request3 = new RequestItem(3L, "pending", 1L, "dave", new Date());
//
//        List<RequestItem> requestItems = Arrays.asList(request1, request2, request3);
//
//        when(viewRequestsImpl.getRequest(1L)).thenReturn(request1);
//        when(viewRequestsImpl.getRequest(2L)).thenReturn(request2);
//        when(viewRequestsImpl.getRequest(3L)).thenReturn(request3);
//
//        mvc.perform(MockMvcRequestBuilders.get("/Admin/approve/1"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/Admin/ViewRequests"));
//
//        viewRequestsImpl.setApproved(request1);
//        viewRequestsImpl.setApproved(request2);
//        viewRequestsImpl.setApproved(request3);
//
//        System.out.println("Request 1 after approval: " + request1);
//        System.out.println("Request 2 after approval: " + request2);
//        System.out.println("Request 3 after approval: " + request3);
//
//        assertEquals("approved", request1.getApproved());
//        assertEquals("approved", request2.getApproved());
//        assertEquals("approved", request3.getApproved());
//    }
//
//
//}
