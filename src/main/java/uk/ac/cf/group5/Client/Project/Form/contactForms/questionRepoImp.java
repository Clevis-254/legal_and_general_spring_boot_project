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
                rs.getInt("questionNum"),
                rs.getString("questionContactText"),
                rs.getDate("date"),
                rs.getString("category")
        );
    }

    @Override
    public List<questionItem> questionItems(Date date) {
        String sql = "select id, question_num, question_user_text, category from questions WHERE date < ? AND category <> 'textarea'\n";
        return jdbctemplate.query(sql, questionItemMapper, date);
    }



    @Override
    public List<questionItem> getTextAreaQuestions(Date date) {
        String sql = "SELECT id, question_num, question_user_text, category FROM questions WHERE date < ? AND category = 'textarea'\n";
        return jdbctemplate.query(sql, questionItemMapper);
    }
}
