package uk.ac.cf.group5.Client.Project.Form.Contacts;

import java.util.List;

public class ContactsRepositoryIpml implements ContactsRepository {

        List<ContactItem> contacts;

        @Override
        public List<ContactItem> getAllContacts() {
            return contacts;
        }

        @Override
        public void addContact(ContactForm contact) {
            try conn
        }

        @Override
        public void removeContact(ContactItem contact) {
            contacts.remove(contact);
        }

        @Override
        public void updateContact(ContactItem contact) {
            contacts.remove(contact);
            contacts.add(contact);
        }

}