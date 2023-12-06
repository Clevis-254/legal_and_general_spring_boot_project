package uk.ac.cf.group5.Client.Project.Form.Contacts;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContactsRepository {

    List<ContactItem> getAllContacts();

    void addContact(ContactForm contactForm);

    ContactItem getContactById(String id);

}
