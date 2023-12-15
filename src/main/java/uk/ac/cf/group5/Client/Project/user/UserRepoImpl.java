package uk.ac.cf.group5.Client.Project.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password")
        );
    }

    public UserItem getUserItem(String username) {
        String sql = "select * from users where username = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, username);
    }
    public List<UserItem> getUserItems() {
        String sql = "select * from users";
        return jdbctemplate.query(sql, UserItemMapper);
    }

    public void add(UserItem user) {
        if (user.isNew()){
            insert(user);
        } else {
            update(user);
        }
    }

    public UserItem findByEmail(String username){
        String sql = "select * from users where username = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, username);
    }

    private void update(UserItem user) {
        String UserInsertSql =
                "update users set name = ?, password = ? where username = ?";
        jdbctemplate.update(UserInsertSql,
                user.getName(),
                user.getPassword(),
                user.getUsername()
        );
    }

    private void insert(UserItem user) {
        String UserInsertSql =
                "insert into users " +
                        "(name, username, password)" +
                        " values (?,?,?)";
        jdbctemplate.update(UserInsertSql,
                user.getUsername(),
                user.getName(),
                user.getPassword()
        );
    }
    public UserItem getItem(long id) {
        String sql = "select * from users where id = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, id);
    }






}
