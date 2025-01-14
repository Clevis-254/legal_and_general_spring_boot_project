package uk.ac.cf.group5.Client.Project.Form.contactForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class questionRepoImp implements questionRepo{

    @Autowired
    private JdbcTemplate jdbctemplate;

    private RowMapper<questionItem> questionItemMapper;


    public questionRepoImp(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setQuestionMapper();
    }
    private void setQuestionMapper() {

        questionItemMapper = (rs, i) -> new questionItem(
                rs.getLong("id"),
                rs.getString("question_contact_text"),
                rs.getInt("question_num"),
                rs.getString("category")
        );
    }

    @Override
    public List<questionItem> getRadioQuestions(Date date) {
        String sql = "SELECT id, question_num, question_contact_text, category FROM questions" +
                "  WHERE category != 'textArea' AND (question_num, date_added) IN (SELECT question_num, MAX(date_added) FROM questions GROUP BY question_num)" +
                " ORDER BY question_num";
        return jdbctemplate.query(sql, questionItemMapper);
    }



    @Override
    public List<questionItem> getTextAreaQuestions(Date date) {
        String sql = "SELECT id, question_num, question_contact_text, category FROM questions" +
                "  WHERE category = 'textArea' AND (question_num, date_added) IN (SELECT question_num, MAX(date_added) FROM questions GROUP BY question_num)" +
                " ORDER BY question_num";
        return jdbctemplate.query(sql, questionItemMapper);
    }
}
