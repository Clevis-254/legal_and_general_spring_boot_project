package uk.ac.cf.group5.Client.Project.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.Reviews.RequestRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

private UserRepository userRepository;
    public UserServiceImpl (UserRepository repository){
        this.userRepository = repository;
    }
    public void add(UserItem user) {
        userRepository.add(user);
    }



    public UserItem getUserItem(String username) {
         return userRepository.getUserItem(username);
    }
    public List<UserItem> getUserItems() {
        return userRepository.getUserItems();
    }
}
