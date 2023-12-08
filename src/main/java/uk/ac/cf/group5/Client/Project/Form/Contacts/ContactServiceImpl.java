package uk.ac.cf.group5.Client.Project.Form.Contacts;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactItem> getContactItems(Integer resultID) {
        return contactRepository.getAllContacts(resultID);
    }

    @Override
    public ContactItem getContactItem(Long id) {
        return contactRepository.getContact(id);
    }

    @Override
    public void save(ContactItem contactItem, Integer resultID) {
        contactRepository.saveContact(contactItem, resultID);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteContact(id);
    }
}
