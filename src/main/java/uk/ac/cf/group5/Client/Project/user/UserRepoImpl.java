package uk.ac.cf.group5.Client.Project.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepository{
    private JdbcTemplate jdbctemplate;
    private RowMapper<UserItem> UserItemMapper;

    public UserRepoImpl(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setUserMapper();
    }

    private void setUserMapper() {

        UserItemMapper = (rs, i) -> new UserItem(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    public UserItem getUserItem(Long id) {
        String sql = "select id,username from users where id = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, id);
    }
    public List<UserItem> getUserItems() {
        String sql = "select * from users";
        return jdbctemplate.query(sql, UserItemMapper);
    }

    public void add(UserItem user) {
        String UserInsertSql =
                "insert into users " +
                        "(username, email, password)" +
                        " values (?,?,?)";
        jdbctemplate.update(UserInsertSql,
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

}
