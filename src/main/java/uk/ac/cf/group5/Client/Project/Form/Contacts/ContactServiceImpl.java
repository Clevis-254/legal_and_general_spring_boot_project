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
        return contactRepository.getResultContacts(resultID);
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

    @Override
    public Integer getManagerCount(Integer resultID) {
        return contactRepository.getManagerCount(resultID);
    }

    @Override
    public Integer getPeerCount(Integer resultID) {
        return contactRepository.getPeerCount(resultID);
    }

    @Override
    public Integer getExternalCount(Integer resultID) {
        return contactRepository.getExternalCount(resultID);
    }

    @Override
    public List<ContactItem> getAllContacts() {
        return contactRepository.getAllContacts();
    }
}
