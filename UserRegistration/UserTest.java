package UserRegistration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {



    @Test
    void testgetUsername() {
        String expectedUsername = "Hussain_1";
        String password = "pass123";

        User user = new User(expectedUsername, password);

        String actualUsername = user.getUsername();

        assertEquals(expectedUsername, actualUsername);
    }


    @Test
    void testgetPassword() {
        String username = "Bayan18";
        String expectedPassword = "password456";
        User user = new User(username, expectedPassword);


        String actualPassword = user.getPassword();


        assertEquals(expectedPassword, actualPassword);
    }
}