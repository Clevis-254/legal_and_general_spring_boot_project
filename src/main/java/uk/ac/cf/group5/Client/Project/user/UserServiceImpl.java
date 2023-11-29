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

    public UserItem getUserItem(Long id){
       return userRepository.getUserItem(id);
    }

    public List<UserItem> getUserItems() {
        return userRepository.getUserItems();
    }

   public  UserItem findByEmail(String email){
       return userRepository.findByEmail(email.);
   };
}
