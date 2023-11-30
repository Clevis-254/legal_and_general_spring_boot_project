package uk.ac.cf.group5.Client.Project.form;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cf.group5.Client.Project.Form.Question;
import uk.ac.cf.group5.Client.Project.Form.QuestionRepository;
import uk.ac.cf.group5.Client.Project.Form.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllQuestions() {
        // Mock data
        List<Question> mockQuestions = new ArrayList<>();
        mockQuestions.add(new Question(1L, "Question 1", "Category 1"));
        mockQuestions.add(new Question(2L, "Question 2", "Category 2"));

        // Define mock behavior
        when(questionRepository.findAll()).thenReturn(mockQuestions);

        // Call the method to be tested
        List<Question> result = questionService.getAllQuestions();

        // Verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());

        // Optionally, verify specific elements or values
        Assertions.assertEquals("Question 1", result.get(0).getQuestionText());
        Assertions.assertEquals("Category 2", result.get(1).getCategory());

        // Verify repository method invocation
        Mockito.verify(questionRepository, Mockito.times(1)).findAll();
    }
}
