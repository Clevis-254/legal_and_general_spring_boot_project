package uk.ac.cf.group5.Client.Project.Form.Contacts;

import java.util.List;

public interface ContactRepository {

    void saveContact(ContactItem contact, Integer resultID);

    void deleteContact(Long contactID);

    List<ContactItem> getAllContacts(Integer resultID);

    ContactItem getContact(Long id);

}
