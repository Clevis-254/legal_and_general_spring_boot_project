package uk.ac.cf.group5.Client.Project.user;

import java.util.List;

public interface UserRepository {

    List<UserItem> getUserItems();

    UserItem getUserItem(String username);
    UserItem getItem(long id);

    void add(UserItem Item);
    UserItem findByEmail(String username);
}
