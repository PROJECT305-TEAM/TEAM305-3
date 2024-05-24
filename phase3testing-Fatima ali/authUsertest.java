package phase3testing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class authUserTest {

    @Test
    public void authenticate() {
        // Arrange
        authUser authUser = new authUser("admin111", "password123");
        boolean result = authUser.authenticate();
        Assert.assertTrue(result);
    }

    @Test
    public void logout() {
        // Arrange
        authUser authUser = new authUser("invalid", "credentials");
        boolean result = authUser.authenticate();
        Assert.assertFalse(result);}
}
