package UserRegistration;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationServiceTest {

    @Test
    void testRegisterUser() {

        List<User> users = new ArrayList<>();
        UserRegistrationService registrationService = new UserRegistrationService(users);

        // Act
        boolean result = registrationService.registerUser("Hussain1", "password123");

        // Assert
        assertTrue(result); //Registration succeed for a new username
        assertEquals(1, users.size());
        assertEquals("Hussain1", users.get(0).getUsername());

    }

    @Test
    void testRegisterExistingUser() {

        List<User> users = new ArrayList<>();
        users.add(new User("Ftaim", "password"));
        UserRegistrationService registrationService = new UserRegistrationService(users);

        boolean result = registrationService.registerUser("Ftaim", "newpassword");


        assertFalse(result); // Registration should fail because username already exists
        assertEquals(1, users.size());
    }


    @Test
    void testValidateUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("ruby", "password123"));
        UserRegistrationService registrationService = new UserRegistrationService(users);


        boolean result = registrationService.validateUser("ruby", "password123");


        assertTrue(result); // Validation should succeed if correct credentials
    }

    @Test
    void testUserWithInvalidCredentials() {

        List<User> users = new ArrayList<>();
        users.add(new User("ruby", "password123"));
        UserRegistrationService registrationService = new UserRegistrationService(users);


        boolean result = registrationService.validateUser("ruby", "wrongpassword");


        assertFalse(result); // Validation should fail for incorrect password
    }


}

