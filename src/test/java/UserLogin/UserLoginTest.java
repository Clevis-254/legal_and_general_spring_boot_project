package UserLogin;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.group5.Client.Project.user.UserController;
import uk.ac.cf.group5.Client.Project.user.UserItem;
import uk.ac.cf.group5.Client.Project.user.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class UserLoginTest {

    @Test
    public void testLogin() {

        UserService userService = mock(UserService.class);

        UserController userController = new UserController(userService);

        // Creating a test for a UserItem
        UserItem testUserItem = new UserItem("testUsername", "testPassword");

        when(userService.findByEmail("testUsername")).thenReturn(testUserItem);

        ModelAndView actualModelAndView = userController.Login();

        // Make sure that the findByEmail method from UserService will call the correct username
        verify(userService).findByEmail("testUsername");
        verifyNoMoreInteractions(userService);

        // expected result
        ModelAndView expectedModelAndView = new ModelAndView("/LoginPage");

        assertEquals(expectedModelAndView.getViewName(), actualModelAndView.getViewName());
    }
}
