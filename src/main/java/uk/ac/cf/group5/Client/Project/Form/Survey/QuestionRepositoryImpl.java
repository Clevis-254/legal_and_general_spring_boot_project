package uk.ac.cf.group5.Client.Project.Form.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionItem;
import uk.ac.cf.group5.Client.Project.Form.Survey.QuestionRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final DataSource dataSource;

    @Autowired
    public QuestionRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<QuestionItem> findAll() {
        List<QuestionItem> questions = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, question_text, category FROM questions");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                QuestionItem question = new QuestionItem();
                question.setId(resultSet.getLong("id"));
                question.setQuestionText(resultSet.getString("question_text"));
                question.setCategory(resultSet.getString("category"));
                questions.add(question);
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }

        return questions;
    }
}
