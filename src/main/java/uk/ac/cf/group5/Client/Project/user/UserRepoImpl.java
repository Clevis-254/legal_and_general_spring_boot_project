package uk.ac.cf.group5.Client.Project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepository{

    @Autowired
    private PasswordEncoder passwordEncoder;
    private JdbcTemplate jdbctemplate;
    private RowMapper<UserItem> UserItemMapper;

    public UserRepoImpl(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setUserMapper();
    }

    private void setUserMapper() {

        UserItemMapper = (rs, i) -> new UserItem(
                rs.getLong("id"),
                rs.getString("firstname"),
                rs.getString("secondname"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
        );
    }

    public UserItem getUserItem(String username) {
        String sql = "select * from users where username = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, username);
    }
    // using role users only employee list is suppossed to be generated to the admin.
    public List<UserItem> getUserItems() {
        String sql = "select * from users where role ='ROLE_USER'";
        return jdbctemplate.query(sql, UserItemMapper);
    }
    public boolean checkUserExists(UserItem userItem) {
        String email = userItem.getUsername();
        String sql = "select count(*) from users where username = ?";
        int count = jdbctemplate.queryForObject(sql, Integer.class, email);

        return count > 0;
    }

    public void add(UserItem user) {
        if (checkUserExists(user)){
            update(user);
        } else {
            insert(user);
        }
    }

    public UserItem findByEmail(String username){
        String sql = "select * from users where username = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, username);
    }

    private void update(UserItem user) {
        String UserInsertSql =
                "update users set firstname = ?,secondname = ?  where username = ?";
        jdbctemplate.update(UserInsertSql,
                user.getFirstname(),
                user.getSecondname(),
                user.getUsername()
        );
    }

    public void encodePassword(UserItem user) {
        String plainPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);
//        System.out.println(encodedPassword);
//        System.out.println(plainPassword);
    }
    private void insert(UserItem user) {
        encodePassword(user);
        String UserInsertSql =
                "insert into users " +
                        "(username,firstname, secondname, password,role)" +
                        " values (?,?,?,?,?)";
        jdbctemplate.update(UserInsertSql,
                user.getUsername(),
                user.getFirstname(),
                user.getSecondname(),
                user.getPassword(),
                user.getRole()
        );
    }
    public UserItem getItem(long id) {
        String sql = "select * from users where id = ?";
        return jdbctemplate.queryForObject(sql,UserItemMapper, id);
    }







}
