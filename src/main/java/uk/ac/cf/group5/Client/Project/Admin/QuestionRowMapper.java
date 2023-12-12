package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(resultSet.getInt("id"));
        question.setQuestionNumber(resultSet.getInt("question_num"));
        question.setQuestionText(resultSet.getString("question_user_text"));
        question.setContactQuestionText(resultSet.getString("question_contact_text"));
        question.setDateAdded(resultSet.getDate("date_added"));
        question.setCategory(resultSet.getString("category"));
        return question;
    }
}