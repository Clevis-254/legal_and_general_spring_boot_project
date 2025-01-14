package uk.ac.cf.group5.Client.Project.Reviews;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                rs.getString("approved"),
                rs.getLong("userid"),
                rs.getString("firstname"),
                rs.getString("secondname"),
                rs.getDate("requested")
        );
    }


    public void add(RequestItem request) {
        String RequestInsertSql =
                "insert into requests " +
                        "(userid,firstname,secondname)" +
                        " values (?,?,?)";
        jdbctemplate.update(RequestInsertSql,
                request.getUserId(),
                //request.getApproved(),
                request.getFirstname(),
                request.getSecondname()
        );
    }

    @Override
    public Object findAll() {
        return null;
    }
    public List<RequestItem> getRequestItems(Long userId){
        String sql = "select * from requests where userid = ? order by id desc ";
        return jdbctemplate.query(sql, RequestItemMapper, userId);
    }
}
