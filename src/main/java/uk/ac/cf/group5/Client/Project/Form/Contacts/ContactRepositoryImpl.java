package uk.ac.cf.group5.Client.Project.Form.Contacts;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.user.UserItem;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
                rs.getLong("reviewsId"),
                rs.getString("fname"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("category")
        );
    }

    @Override
    public void saveContact(ContactItem contact, long reviewsId ) {
        String sql = "INSERT INTO contacts (fname, surname , email, category, reviewsId ) VALUES (?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName()  , contact.getEmail(), contact.getCategory(), reviewsId );
    }


    @Override
    public Integer getManagerCount(long reviewsId ) {
        String sql = "SELECT COUNT(*) FROM contacts WHERE category = 'Manager' AND reviewsId  = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, reviewsId );
    }

    @Override
    public Integer getPeerCount(long reviewsId ) {
        String sql = "SELECT COUNT(*) FROM contacts WHERE category = 'Peer' AND reviewsId  = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, reviewsId);
    }

    @Override
    public Integer getExternalCount(long reviewsId) {
        String sql = "SELECT COUNT(*) FROM contacts WHERE category = 'External' AND reviewsId  = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, reviewsId );
    }

    @Override
    public void deleteContact(Long contactID) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        jdbcTemplate.update(sql, contactID);
    }

    @Override
    public List<ContactItem> getResultContacts(long reviewsId ) {
        String sql = "SELECT * FROM contacts WHERE reviewsId  = ?";
        return jdbcTemplate.query(sql, ContactMapper, reviewsId );
    }



    @Override
    public ContactItem getContact(Long reviewsId) {
        String sql = "SELECT * FROM contacts WHERE reviewsId = ?";
        return jdbcTemplate.queryForObject(sql, ContactMapper, reviewsId);
    }

    @Override
    public List<ContactItem> getAllContacts() {
        String sql = "SELECT * FROM contacts";
        return jdbcTemplate.query(sql, ContactMapper);
    }
    @Override
    public List<ContactItem> getItem(long id) {
        String sql = "SELECT * FROM contacts where id = ?";
        return jdbcTemplate.query(sql,ContactMapper, id);
    }


}
