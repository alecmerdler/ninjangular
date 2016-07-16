package services;

import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alec.merdler on 7/8/16.
 */
public class UserFactoryTest {
    UserFactory userFactory;
    String firstName;
    String lastname;
    String username;
    String password;

    @Before
    public void beforeEach() {
        this.userFactory = new UserFactory();
    }

    @Test
    public void testCreateDefaultUser() {
        User user = userFactory.createDefaultUser();

        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("johncleese", user.username);
        assertEquals("password", user.password);
    }

    @Test
    public void testCreateUser() {
        firstName = "John";
        lastname = "Cleese";
        username = "johncleese";
        password = "password";

        User user = userFactory.createUser(firstName, lastname, username, password);

        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("johncleese", user.username);
        assertEquals("password", user.password);
    }
}