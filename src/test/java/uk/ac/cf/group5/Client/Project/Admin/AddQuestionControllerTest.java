package uk.ac.cf.group5.Client.Project.Admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(AddQuestionController.class)
public class AddQuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddQuestionService addQuestionService;

    @Test
    @WithMockUser(username = "notareal@gmail.com", roles = "ADMIN")
    public void showAddQuestionForm() throws Exception {
        // Mock the behavior of your service
        Mockito.when(addQuestionService.getAllQuestions()).thenReturn(Collections.emptyList());
        Mockito.when(addQuestionService.getCurrentQuestions()).thenReturn(Collections.emptyList());

        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/Admin/AddQuestions"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/admin/AddQuestions"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("allQuestions", "currentQuestions"));
    }

    @Test
    @WithMockUser(username = "notareal@gmail.com", roles = "ADMIN")
    public void addQuestion() throws Exception {
        // Mock the behavior of your service
        Mockito.doNothing().when(addQuestionService).saveQuestion(Mockito.any(Question.class));

        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.post("/Admin/AddQuestions")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("questionNumber", "1")
                        .param("questionText", "Sample Question")
                        .param("contactQuestionText", "Sample Contact Question")
                        .param("category", "Collaborative"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/Admin/AddQuestions"));

        // Verify that the service method was called
        Mockito.verify(addQuestionService, Mockito.times(1)).saveQuestion(Mockito.any(Question.class));
    }

}