package uk.ac.cf.group5.Client.Project.Form.Contacts;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepository{

    private JdbcTemplate jdbcTemplate;
    private RowMapper<ContactItem> ContactMapper;


    public ContactRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setContactMapper();
    }

    // Setter for RowMapper
    public void setContactMapper() {
        ContactMapper = (rs, i) -> new ContactItem(
                rs.getLong("id"),
                rs.getLong("result_id"),
                rs.getString("fname"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("category")
        );
    }

    @Override
    public void saveContact(ContactItem contact, Integer resultID) {
        String sql = "INSERT INTO contacts (fname, surname , email, category, result_id) VALUES (?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName()  , contact.getEmail(), contact.getCategory(), resultID);
    }

    @Override
    public void deleteContact(Long contactID) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        jdbcTemplate.update(sql, contactID);
    }

    @Override
    public List<ContactItem> getAllContacts(Integer resultID) {
        String sql = "SELECT * FROM contacts WHERE result_id = ?";
        return jdbcTemplate.query(sql, ContactMapper, resultID);
    }

    @Override
    public ContactItem getContact(Long id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, ContactMapper, id);
    }

}
