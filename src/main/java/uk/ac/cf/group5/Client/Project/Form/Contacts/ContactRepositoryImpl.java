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
    public Long saveContact(ContactItem contact, Long reviewsId) {
        String sql = "INSERT INTO contacts (fname, surname, email, category, reviewsId) VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder(); // Create a key holder to store the generated keys

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getLastName());
            ps.setString(3, contact.getEmail());
            ps.setString(4, contact.getCategory());
            ps.setLong(5, reviewsId);
            return ps;
        }, keyHolder);

        // Retrieve the generated contact ID
        Long generatedId = keyHolder.getKey().longValue();

        return generatedId; // Return the generated contact ID
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
        String sql1 = "DELETE FROM submissions WHERE contactID = ?;";
        jdbcTemplate.update(sql1, contactID);
        String sql = "DELETE FROM contacts WHERE id = ?;";
        jdbcTemplate.update(sql, contactID);
    }

    @Override
    public List<ContactItem> getResultContacts(Long reviewsId ) {
        String sql = "SELECT * FROM contacts WHERE reviewsId  = ?";
        return jdbcTemplate.query(sql, ContactMapper, reviewsId );
    }



    @Override
    public ContactItem getContact(Long contactID) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, ContactMapper, contactID);
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


    @Override
    public Long getReviewId(Long id) {
        String sql = "SELECT reviewsId FROM contacts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, id);
    }

}
