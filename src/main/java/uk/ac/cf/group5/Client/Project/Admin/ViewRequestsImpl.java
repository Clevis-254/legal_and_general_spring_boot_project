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
                rs.getString("approved"),
                rs.getLong("userid"),
                rs.getString("firstname"),
                rs.getString("secondname"),
                rs.getDate("requested")
        );
    }
    public List<RequestItem> getPendingRequestItems() {
        String sql = "SELECT * FROM requests WHERE approved = 'pending' order by id desc";
        return jdbctemplate.query(sql, ViewRequestMapper);
    }

    public RequestItem getRequest(Long id){
        String sql = "select * from requests where id = ?";
        return jdbctemplate.queryForObject(sql, ViewRequestMapper, id);
    }

    public void setApproved(RequestItem request){
        String RequestUpdateSql = "update requests set approved = ? where id = ?";
        jdbctemplate.update(RequestUpdateSql,
                request.getApproved(),
                request.getId()
                );
    }
    public void setCancelled(RequestItem request){
        String RequestUpdateSql = "update requests set approved = 'cancelled' where id = ?";
        jdbctemplate.update(RequestUpdateSql,
                request.getId()
        );
    }
    public RequestItem getUserID(Long id){
        String sql = "select userID from requests where id = ?";
        return jdbctemplate.queryForObject(sql, ViewRequestMapper, id);
    }


}
