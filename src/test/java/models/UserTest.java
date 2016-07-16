package models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by alec.merdler on 7/7/16.
 */
public class UserTest {
    String firstName;
    String lastname;
    String username;
    String password;

    @Before
    public void beforeEach() {
        firstName = "John";
        lastname = "Cleese";
        username = "johncleese";
        password = "password";
    }

    @Test
    public void testCreateUser() {
        User user = new User(firstName, lastname, username, password);

        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("johncleese", user.username);
        assertEquals("password", user.password);
        assertThat(user, instanceOf(Model.class));
    }

    @Test
    public void testChangePasswordValidLength() {
        User user = new User(firstName, lastname, username, password);

        user.changePassword("wubadubdub");

        assertEquals("wubadubdub", user.password);
    }

    @Test
    public void testChangePasswordInvalidLength() {
        User user = new User(firstName, lastname, username, password);
        String originalPassword = user.password;

        user.changePassword("thisIsAReallyLongPasswordThatDefinitelyExceedsTheLengthRequirements");

        assertEquals(originalPassword, user.password);
    }


}