package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

@Repository
public class ViewRequestsImpl {
    private JdbcTemplate jdbctemplate;
    private RowMapper<RequestItem> ViewRequestMapper;


    public ViewRequestsImpl(JdbcTemplate ajdbctemplate){
        this.jdbctemplate = ajdbctemplate;
        setRequestMapper();
    }
    private void setRequestMapper() {

        ViewRequestMapper = (rs, i) -> new RequestItem(
                rs.getLong("id"),
                rs.getBoolean("approved"),
                rs.getLong("userid"),
                rs.getString("username"),
                rs.getDate("requested")
        );
    }
    public List<RequestItem> getAllRequestItems(){
        String sql = "select * from requests where approved = ?";
        return jdbctemplate.query(sql, ViewRequestMapper,false);
    }
}
