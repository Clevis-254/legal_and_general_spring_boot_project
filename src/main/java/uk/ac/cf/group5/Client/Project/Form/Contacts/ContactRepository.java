package uk.ac.cf.group5.Client.Project.Form.Contacts;

import java.util.List;

public interface ContactRepository {

    void saveContact(ContactItem contact, Integer resultID);

    Integer getManagerCount(Integer resultID);

    Integer getPeerCount(Integer resultID);

    Integer getExternalCount(Integer resultID);

    void deleteContact(Long contactID);

    List<ContactItem> getAllContacts(Integer resultID);

    ContactItem getContact(Long id);



}
