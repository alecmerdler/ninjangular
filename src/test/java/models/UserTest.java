package models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by alec.merdler on 7/7/16.
 */
public class UserTest {

    @Test
    public void testCreateNewUser() {
        User user = new User();

        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("johncleese", user.username);
        assertEquals("password", user.password);
        assertThat(user, instanceOf(Model.class));
    }

    @Test
    public void testChangePasswordValidLength() {
        User user = new User();

        user.changePassword("wubadubdub");

        assertEquals("wubadubdub", user.password);
    }

    @Test
    public void testChangePasswordInvalidLength() {
        User user = new User();
        String originalPassword = user.password;

        user.changePassword("thisIsAReallyLongPasswordThatDefinitelyExceedsTheLengthRequirements");

        assertEquals(originalPassword, user.password);
    }

    @Test
    public void testSayCatchphrase() {
        User user = new User();

        String catchphrase = user.sayCatchphrase();

        assertEquals("yo", catchphrase);
    }

    @Test
    public void testGiveParent() {
        User user = new User();
        User parent = new User();

        user.giveParent(parent);

        assertEquals(parent, user.parent);
    }
}