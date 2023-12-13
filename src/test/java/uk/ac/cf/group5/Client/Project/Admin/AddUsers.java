package uk.ac.cf.group5.Client.Project.Admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddUsers {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Test

    public void testAddUser() throws Exception {
        // Create a sample user JSON payload
        String userJson = "{\"username\":\"testUser\",\"firstname\":\"John\",\"secondname\":\"Doe\",\"password\":\"password123\",\"role\":\"ROLE_USER\"}";

        // Perform a POST request to the endpoint that adds users
        mvc.perform(MockMvcRequestBuilders
                        .post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"User added successfully\"}"));

        // Optionally, you can check the database to verify the user was added
        // Example: UserEntity user = userRepository.findByUsername("testUser");
        // Assert.assertNotNull(user);
        // Assert.assertEquals("John", user.getFirstname());
        // Assert.assertEquals("Doe", user.getSecondname());
    }
}
