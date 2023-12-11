package uk.ac.cf.group5.Client.Project.Submissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.user.UserItem;
@Repository
public class SubmissionRepoImpl implements SubmissionRepo{

    @Autowired

    private JdbcTemplate jdbctemplate;
    private RowMapper<submissionItem> SubmissionItemMapper;

    public SubmissionRepoImpl(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setSubmissionMapper();
    }

    private void setSubmissionMapper() {

        SubmissionItemMapper = (rs, i) -> new submissionItem(
                rs.getLong("id"),
                rs.getLong("userID"),
                rs.getLong("reviewID")
        );
    }


    @Override
    public void add(submissionItem Item) {
        String submissionInsertSql =
                "insert into submissions " +
                        "(userID, reviewID)" +
                        " values (?,?)";
        jdbctemplate.update(submissionInsertSql,
                Item.getReviewID(),
                Item.getUserID()
        );
    }

    @Override
    public submissionItem getSubmissionItem(Long id) {
        String sql = "select * from submissions where reviewID = ?";
        return jdbctemplate.queryForObject(sql,SubmissionItemMapper,id);
    }
}

