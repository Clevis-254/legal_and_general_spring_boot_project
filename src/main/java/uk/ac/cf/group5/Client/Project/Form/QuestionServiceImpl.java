package uk.ac.cf.group5.Client.Project.Form;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final DataSource dataSource;

    public QuestionServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, question_text, category FROM questions")) {

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getLong("id"));
                question.setQuestionText(rs.getString("question_text"));
                question.setCategory(rs.getString("category"));
                questions.add(question);
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }

        return questions;
    }

}

