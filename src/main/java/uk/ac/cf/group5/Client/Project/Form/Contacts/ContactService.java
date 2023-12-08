package uk.ac.cf.group5.Client.Project.Form.Contacts;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

public interface ContactService {


    List<ContactItem> getContactItems(Integer resultID);

    ContactItem getContactItem(Long id);

    void save(ContactItem menuItem, Integer resultID);

    void delete(Long id);

}
