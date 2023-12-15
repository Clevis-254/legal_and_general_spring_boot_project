package uk.ac.cf.group5.Client.Project.Submissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                rs.getLong("userID"),
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
    public List<SubmissionItem> getsubmissionItems(Long reviewID){
        String sql = "select * from submissions where reviewID = ?";
        return jdbctemplate.query(sql, SubmissionItemMapper,reviewID);
    }

    public SubmissionItem getSubmission(Long submissionId) {
        String sql = "select * from submissions where id = ?";
        return jdbctemplate.queryForObject(sql,SubmissionItemMapper,submissionId);
    }

    @Override
    public SubmissionItem DeleteSubmissionItem(Long contactID){
    String sql = "DELETE FROM submissions WHERE contactID = ?";
    return jdbctemplate.queryForObject(sql,SubmissionItemMapper,contactID);
    }

    @Override
    public SubmissionItem getSubmissionbyCon(Long id){
        String sql = "select * from submissions where contactID = ?";
        return jdbctemplate.queryForObject(sql,SubmissionItemMapper,id);
    }
}

