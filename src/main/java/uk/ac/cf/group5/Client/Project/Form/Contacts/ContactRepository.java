package uk.ac.cf.group5.Client.Project.Form.Contacts;

import java.util.List;

public interface ContactRepository {

    void saveContact(ContactItem contact, long reviewsID);

    Integer getManagerCount(long reviewsID);

    List<ContactItem> getItem(long id);

    Integer getPeerCount(long reviewsID);

    Integer getExternalCount(long reviewsID);

    void deleteContact(Long contactID);

    List<ContactItem> getResultContacts(long reviewsID);

    ContactItem getContact(Long reviewsId);


    List<ContactItem> getAllContacts();
}
