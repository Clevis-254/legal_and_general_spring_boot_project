package uk.ac.cf.group5.Client.Project.Submissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SubmissionRepoImpl implements SubmissionRepo{

    @Autowired

    private JdbcTemplate jdbctemplate;
    private RowMapper<SubmissionItem> SubmissionItemMapper;

    public SubmissionRepoImpl(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setSubmissionMapper();
    }

    private void setSubmissionMapper() {

        SubmissionItemMapper = (rs, i) -> new SubmissionItem(
                rs.getLong("id"),
                rs.getLong("contactID"),
                rs.getLong("reviewID")
        );
    }


    @Override
    public void add(Long contactID, Long reviewID, Long userID) {
        String submissionInsertSql =
                "INSERT INTO submissions " +
                        "(contactID,userID, reviewID)" +
                        " VALUES (?, ?,?)";

        jdbctemplate.update(submissionInsertSql, contactID, userID, reviewID);
    }

    @Override
    public SubmissionItem getSubmissionItem(Long id) {
        String sql = "select * from submissions where reviewID = ?";
        return jdbctemplate.queryForObject(sql,SubmissionItemMapper,id);
    }
    @Override
    public SubmissionItem getSubmission(Long submissionId) {
        String sql = "select * from submissions where id = ?";
        return jdbctemplate.queryForObject(sql,SubmissionItemMapper,submissionId);
    }
}

