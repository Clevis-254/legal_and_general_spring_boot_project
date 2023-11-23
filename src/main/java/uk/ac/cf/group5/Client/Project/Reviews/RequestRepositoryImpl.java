package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepositoryImpl implements RequestRepository {

    private JdbcTemplate jdbctemplate;
    private RowMapper<RequestItem> RequestItemMapper;

    public RequestRepositoryImpl(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setRequestMapper();
    }

    private void setRequestMapper() {

        RequestItemMapper = (rs, i) -> new RequestItem(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getBoolean("isapproved"),
                rs.getLong("userid")
        );
    }


    public void add(RequestItem request) {
        String RequestInsertSql =
                "insert into requests " +
                        "(username, approved, userId)" +
                        " values (?,?,?)";
        jdbctemplate.update(RequestInsertSql,
                request.getUsername(),
                request.getApproved(),
                request.getUserId()
        );
    }
}
