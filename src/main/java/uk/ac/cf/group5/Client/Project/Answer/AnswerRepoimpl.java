package uk.ac.cf.group5.Client.Project.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.user.UserItem;

@Repository
public class AnswerRepoimpl implements AnswerRepo{

    @Autowired
    private JdbcTemplate jdbctemplate;
    private RowMapper<AnswerItem> AnswerItemMapper;

    public AnswerRepoimpl(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setAnswerMapper();
    }

    private void setAnswerMapper() {

        AnswerItemMapper = (rs, i) -> new AnswerItem(
                rs.getLong("id"),
                rs.getLong("question_id"),
                rs.getLong("sub_id"),
                rs.getString("answer")
        );
    }

    @Override
    public void add(AnswerItem Item) {
        String answersInsertSql =
                "insert into answers " +
                        "(questionID,subID, answer)" +
                        " values (?,?,?)";
        jdbctemplate.update(answersInsertSql,
                Item.getQuestion_id(),
                Item.getSub_id(),
                Item.getAnswer()
        );
    }
}
