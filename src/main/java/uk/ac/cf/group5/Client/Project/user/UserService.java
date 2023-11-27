package uk.ac.cf.group5.Client.Project.user;

import java.util.List;

public interface UserService {
    UserItem getUserItem(Long id);
    List<UserItem> getUserItems();

    void add(UserItem Item);

}
