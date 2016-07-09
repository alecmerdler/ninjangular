package services;

import models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alec.merdler on 7/8/16.
 */
public class UserFactoryTest {

    @Test
    public void testCreateUser() {
        UserFactory userFactory = new UserFactory();

        User user = userFactory.createUser();

        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("johncleese", user.username);
        assertEquals("password", user.password);
    }
}