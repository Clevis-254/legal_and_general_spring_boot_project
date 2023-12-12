package uk.ac.cf.group5.Client.Project.Form.contactForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
                rs.getString("question"),
                rs.getString("category")
        );
    }

    @Override
    public List<questionItem> questionItems() {
        String sql = "select id, question_contact_text, question_num, category from questions WHERE category != 'textarea' and date_added  ORDER BY question_num ASC";
        return jdbctemplate.query(sql, questionItemMapper);
    }



    @Override
    public List<questionItem> getTextAreaQuestions() {
        String sql = "SELECT * FROM contact_questions WHERE category = 'textarea'\n";
        return jdbctemplate.query(sql, questionItemMapper);
    }
}
