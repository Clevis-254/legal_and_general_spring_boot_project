package uk.ac.cf.group5.Client.Project.form;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactRepository;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

public class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetAllContacts() {
        // Mock data
        List<ContactItem> mockContacts = new ArrayList<>();
        mockContacts.add(new ContactItem(1L, 1L, "John", "Smith", "", "Manager"));
        mockContacts.add(new ContactItem(2L, 1L, "Jane", "Doe", "", "Peer"));

        // Define mock behavior
        when(contactRepository.getAllContacts()).thenReturn(mockContacts);

        // Call the method to be tested
        List<ContactItem> result = contactService.getAllContacts();

        // Verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2L, result.size());
}

@Test
    void testGetContactsByResultID() {
        // Mock data
        List<ContactItem> mockContacts = new ArrayList<>();
        mockContacts.add(new ContactItem(1L, 1L, "John", "Smith", "", "Manager"));
        mockContacts.add(new ContactItem(2L, 1L, "Jane", "Doe", "", "Peer"));
        mockContacts.add(new ContactItem(3L, 2L, "John", "Doe", "", "Manager"));

    // Define mock behavior for resultID = 1L
    when(contactRepository.getResultContacts(1L)).thenReturn(
            mockContacts.stream()
                    .filter(contact -> contact.getResultID() == 1L)
                    .collect(Collectors.toList())
    );

// Call the method to be tested
    List<ContactItem> result = contactService.getContactItems(1L);

// Verify the result
    Assertions.assertNotNull(result);
    Assertions.assertEquals(2L, result.size());
    Assertions.assertEquals(1L, result.get(0).getResultID());
    Assertions.assertEquals(1L, result.get(1).getResultID());
}

@Test
    void testAddContact() {
        // Mock data
        ContactItem mockContact = new ContactItem(1L, 1L, "John", "Smith", "", "Manager");

        // Call the method to be tested
        contactService.save(mockContact, 1L);
        ContactItem result = contactService.getContactItem(1L);

        // Verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L, result.getResultID());
        Assertions.assertEquals("John", result.getFirstName());
        Assertions.assertEquals("Smith", result.getLastName());
        Assertions.assertEquals("", result.getEmail());
        Assertions.assertEquals("Manager", result.getCategory());
    }

    @Test
    void testDeleteContact() {
        // Mock data
        ContactItem mockContact = new ContactItem(1L, 1L, "John", "Smith", "", "Manager");

        // Call the method to be tested
        contactService.save(mockContact, 1L);
        contactService.delete(1L);
        ContactItem result = contactService.getContactItem(1L);

        // Verify the result
        Assertions.assertNull(result);
    }

    @Test
    void testGetManagerCount() {
        // Mock data
        List<ContactItem> mockContacts = new ArrayList<>();
        mockContacts.add(new ContactItem(1L, 1L, "John", "Smith", "", "Manager"));
        mockContacts.add(new ContactItem(2L, 1L, "Jane", "Doe", "", "Peer"));
        mockContacts.add(new ContactItem(3L, 2L, "John", "Doe", "", "External"));

        // Define mock behavior
        when(contactRepository.getManagerCount(1L)).thenReturn(
                mockContacts.stream()
                        .filter(contact -> contact.getCategory().equals("Manager"))
                        .collect(Collectors.toList())
                        .size()
        );

        // Call the method to be tested
        Integer result = contactService.getManagerCount(1L);

        // Verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result);
    }


}
