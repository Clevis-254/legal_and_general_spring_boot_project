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
    public List<ContactItem> getContactItems(long reviewsId ) {
        return contactRepository.getResultContacts(reviewsId );
    }


    @Override
    public void save(ContactItem contactItem, long reviewsId ) {
        contactRepository.saveContact(contactItem, reviewsId );
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteContact(id);
    }

    @Override
    public Integer getManagerCount(long reviewsId ) {
        return contactRepository.getManagerCount(reviewsId );
    }

    @Override
    public Integer getPeerCount(long reviewsId ) {
        return contactRepository.getPeerCount(reviewsId );
    }

    @Override
    public Integer getExternalCount(long reviewsId ) {
        return contactRepository.getExternalCount(reviewsId );
    }

    @Override
    public List<ContactItem> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @Override
   public ContactItem getContactItem(long reviewsId){
        return contactRepository.getContact(reviewsId);
    }
}

