package uk.ac.cf.group5.Client.Project.Form.Contacts;

import java.util.List;

public interface ContactRepository {

    Long saveContact(ContactItem contact, Long reviewsID);

    Integer getManagerCount(long reviewsID);

    Integer getPeerCount(long reviewsID);

    Integer getExternalCount(long reviewsID);

    void deleteContact(Long contactID);

    List<ContactItem> getResultContacts(Long reviewsID);

    ContactItem getContact(Long reviewsId);

    Long getReviewId(Long id);


    List<ContactItem> getAllContacts();
}
