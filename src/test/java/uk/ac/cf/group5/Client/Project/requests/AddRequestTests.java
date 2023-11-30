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
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.Reviews.RequestRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.apache.el.util.MessageFactory.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddRequestTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RequestRepository repository;


    @Test
    @WithMockUser(username="dave", roles="USER")
    public void shouldGetThreeItems() throws Exception {
        RequestItem request1 = new RequestItem(1L,false,1l,"dave",new Date());
        RequestItem request2 = new RequestItem(2l,false,1l,"dave",new Date());
        RequestItem request3 = new RequestItem(3L,false,1l,"dave",new Date());

        List<RequestItem> requestItems = Arrays.asList(request1, request2, request3);

        when(repository.findAll()).thenReturn(requestItems);
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get("/reviews"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
    }
}
