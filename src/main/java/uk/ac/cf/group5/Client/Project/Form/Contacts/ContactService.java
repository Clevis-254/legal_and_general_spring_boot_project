package uk.ac.cf.group5.Client.Project.Form.Contacts;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

import java.util.List;

public interface ContactService {


    List<ContactItem> getContactItems(long reviewsID);

   ContactItem getContactItem(long reviewsId);

    void save(ContactItem menuItem, long reviewsID);

    void delete(Long id);

    Integer getManagerCount(long reviewsID);

    Integer getPeerCount(long reviewsID);

    Integer getExternalCount(long reviewsID);

    List<ContactItem> getAllContacts();
}
