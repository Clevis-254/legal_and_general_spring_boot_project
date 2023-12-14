package uk.ac.cf.group5.Client.Project.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddQuestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveQuestion(Question question) {
        String sql = "INSERT INTO questions (question_num, question_user_text, question_contact_text, date_added, category) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                question.getQuestionNumber(),
                question.getQuestionText(),
                question.getContactQuestionText(),
                question.getDateAdded(),
                question.getCategory());
    }
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM questions";
        return jdbcTemplate.query(sql, new QuestionRowMapper());
    }

    public List<Question> getCurrentQuestions() {
        String sql = "SELECT * FROM questions " +
                "WHERE (question_num, date_added) IN " +
                "(SELECT question_num, MAX(date_added) FROM questions GROUP BY question_num) " +
                "ORDER BY question_num";
        return jdbcTemplate.query(sql, new QuestionRowMapper());
    }
}
