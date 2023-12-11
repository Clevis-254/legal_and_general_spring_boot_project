//package uk.ac.cf.group5.Client.Project.AdminLogin;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import uk.ac.cf.group5.Client.Project.user.UserController;
//import uk.ac.cf.group5.Client.Project.user.UserService;
//
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Set;
//
//
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//
//public class UserLoginTestWithAdminLoginTest {
//
//        @Mock
//        private UserService userService;
//
//        @InjectMocks
//        private UserController userController;
//
//        private MockMvc mockMvc;
//
//        @Test
//        public void testLoginSuccessRedirect_AdminRole() throws Exception {
//            mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//
//            MockHttpServletRequest request = new MockHttpServletRequest();
//            MockHttpServletResponse response = new MockHttpServletResponse();
//
//            Authentication authResult = createAuthenticationWithRole("ROLE_ADMIN");
//
//            userController.LoginSuccessRedirect(request, response, authResult);
//
//            //response is redirected to /Admin/AdminMenu
//            mockMvc.perform(get(response.getRedirectedUrl()))
//                    .andExpect(redirectedUrl("/Admin/AdminMenu"));
//        }
//
//        @Test
//        public void testLoginSuccessRedirect_UserRole() throws Exception {
//            mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//
//            MockHttpServletRequest request = new MockHttpServletRequest();
//            MockHttpServletResponse response = new MockHttpServletResponse();
//
//            Authentication authResult = createAuthenticationWithRole("ROLE_USER");
//
//            userController.LoginSuccessRedirect(request, response, authResult);
//
//            //response is redirected to /dashboard
//            mockMvc.perform(get(response.getRedirectedUrl()))
//                    .andExpect(redirectedUrl("/dashboard"));
//        }
//
//        @Test
//        public void testLoginSuccessRedirect_OtherRole() throws Exception {
//            mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//
//            MockHttpServletRequest request = new MockHttpServletRequest();
//            MockHttpServletResponse response = new MockHttpServletResponse();
//
//            Authentication authResult = createAuthenticationWithRole("OTHER_ROLE");
//
//            userController.LoginSuccessRedirect(request, response, authResult);
//
//            //response is redirected to /login
//            mockMvc.perform(get(response.getRedirectedUrl()))
//                    .andExpect(redirectedUrl("/login"));
//        }
//    private Authentication createAuthenticationWithRole(String role) {
//        Authentication authentication = mock(Authentication.class);
//        Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(role));
//
//        when(authentication.getAuthorities()).thenReturn((Collection<? extends GrantedAuthority>) authorities);
//        return authentication;
//    }
//    }