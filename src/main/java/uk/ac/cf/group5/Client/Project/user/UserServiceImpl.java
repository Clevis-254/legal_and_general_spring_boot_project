package uk.ac.cf.group5.Client.Project.user;

import org.springframework.stereotype.Service;

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

    public UserItem getItem(long id) {
        return userRepository.getItem(id);
    }

    public UserItem getUserItem(String username) {
         return userRepository.getUserItem(username);
    }
    public List<UserItem> getUserItems() {
        return userRepository.getUserItems();
    }

   public  UserItem findByEmail(String username){
       return userRepository.findByEmail(username);
   };
}
