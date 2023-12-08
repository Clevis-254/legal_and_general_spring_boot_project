//package uk.ac.cf.group5.Client.Project.Login;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.test.web.servlet.MockMvc;
//import uk.ac.cf.group5.Client.Project.user.UserController;
//
//import java.util.Collections;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    // Inject the MockMvc bean provided by Spring Test
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testLoginSuccessRedirectForAdmin() throws Exception {
//        // Set up a mock authentication context with ROLE_ADMIN authority
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken("admin", "password",
//                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
//
//        mockMvc.perform(get("/LoginSuccess"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/Admin/AdminMenu"));
//    }
//
//    @Test
//    public void testLoginSuccessRedirectForUser() throws Exception {
//        // Set up a mock authentication context with ROLE_USER authority
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken("user", "password",
//                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
//
//        mockMvc.perform(get("/LoginSuccess"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/dashboard"));
//    }
//
//    @Test
//    public void testLoginSuccessRedirectForUnknownRole() throws Exception {
//        // Set up a mock authentication context with an unknown role
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken("unknown", "password",
//                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_UNKNOWN"))));
//
//        mockMvc.perform(get("/LoginSuccess"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/login"));
//    }
//}
