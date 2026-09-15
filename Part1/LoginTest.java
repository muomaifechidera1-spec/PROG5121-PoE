import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testUserName_CorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUserName_IncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPassword_MeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPassword_DoesNotMeetComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneNumber_CorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneNumber_IncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLogin_Successful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLogin_Failed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("kyl_1", "WrongPassword1!"));
    }

    @Test
    public void testReturnLoginStatus_Successful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean successful = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle Smith, it is great to see you again.",
                login.returnLoginStatus(successful));
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean successful = login.loginUser("kyl_1", "WrongPassword1!");
        assertEquals("Username or password incorrect, please try again.",
                login.returnLoginStatus(successful));
    }
}
