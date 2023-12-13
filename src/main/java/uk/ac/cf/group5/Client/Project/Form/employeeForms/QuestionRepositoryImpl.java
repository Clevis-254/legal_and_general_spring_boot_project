
package uk.ac.cf.group5.Client.Project.Form.employeeForms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<QuestionItem> questionItemMapper;

    @Autowired
    public QuestionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setQuestionMapper();
    }

    private void setQuestionMapper() {
        questionItemMapper = (rs, i) -> new QuestionItem(
                rs.getLong("id"),
                rs.getString("question_user_text"),
                rs.getString("category"),
                rs.getInt("question_num")
        );
    }

    @Override
    public List<QuestionItem> findAll() {
        String sql = "SELECT * FROM questions";
        return jdbcTemplate.query(sql, questionItemMapper);
    }

    @Override
    public List<QuestionItem> findTextAreaQuestions(Date date){
        String sql = "SELECT id, question_user_text, category, question_num FROM questions WHERE category = 'textarea' AND date_added <= ?";
        return jdbcTemplate.query(sql, questionItemMapper, date);
    }

    @Override
    public List<QuestionItem> findRadioQuestions(Date date){
        String sql = "SELECT id, question_user_text, category, question_num FROM questions WHERE category != 'textarea' AND date_added <= ?";
        return jdbcTemplate.query(sql, questionItemMapper, date);
    }


}
