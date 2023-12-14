package uk.ac.cf.group5.Client.Project.Form.Contacts.Email;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.Form.Contacts.ContactItem;
@Repository
public class ContactEmailImpl {

    private JdbcTemplate jdbctemplate;
    private RowMapper<ContactItem> ViewRequestMapper;
    public ContactEmailImpl(JdbcTemplate bjdbctemplate){
        this.jdbctemplate = bjdbctemplate;
        setRequestMapper();
    }
    private void setRequestMapper() {

        ViewRequestMapper = (em, i) -> new ContactItem(
                em.getLong("id"),
                em.getLong("reviewsID"),
                em.getString("firstName"),
                em.getString("lastName"),
                em.getString("email"),
                em.getString("category")
        );
    }
}



