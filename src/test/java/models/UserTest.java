package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

        user.changePassword(";lkasjdf;lsadkjfl;dasjfl;sadjflkajsldfjlkjlk;j;ljlkjlkjljl");

        assertEquals(originalPassword, user.password);
    }

    @Test
    public void testSayCatchphrase() {
        User user = new User();

        String catchphrase = user.sayCatchphrase();

        assertEquals("yo", catchphrase);
    }
}