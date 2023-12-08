package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.user.UserItem;

@Repository
public class EmailImpl {

    private JdbcTemplate jdbctemplate;
    private RowMapper<UserItem> ViewRequestMapper;
    public EmailImpl(JdbcTemplate ajdbctemplate){
        this.jdbctemplate = ajdbctemplate;
        setRequestMapper();
    }
    private void setRequestMapper() {

        ViewRequestMapper = (em, i) -> new UserItem(
                em.getLong("id"),
                em.getString("name"),
                em.getString("Username"),
                em.getString("password")
                );
    }

  /*  public UserItem getUserEmail(Long id){
        String sql = "select username from users where id = ?";
        return jdbctemplate.queryForObject(sql, ViewRequestMapper, id);
    }
    public UserItem getUserName(Long id){
        String sql = "select name from users where id = ?";
        String sql = "select username from users where id = ?";
        return jdbctemplate.queryForObject(sql, ViewRequestMapper, id);
    }*/
}
