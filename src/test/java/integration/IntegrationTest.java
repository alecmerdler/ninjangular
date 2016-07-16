package integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Budget;
import models.User;
import ninja.NinjaTest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by alec.merdler on 7/12/16.
 */
public class IntegrationTest extends NinjaTest {
    String serverAddress;
    String agbizAddress;
    ObjectMapper objectMapper;

    @Before
    public void beforeEach() {
        objectMapper = new ObjectMapper();
        serverAddress = getServerAddress();
        agbizAddress = "http://agbizdev.cosine.oregonstate.edu";
    }

    @Test
    public void testIndexGET() {
        String result = ninjaTestBrowser.makeRequest(serverAddress + "/");
        try {
            HashMap<String, String> resultMap = objectMapper.readValue(result, HashMap.class);
            assertEquals("Welcome!", resultMap.get("title"));
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUserGET() {
        String result = ninjaTestBrowser.makeRequest(serverAddress + "/user");
        try {
            User user = objectMapper.readValue(result, User.class);
            assertEquals("johncleese", user.username);
            assertEquals("John", user.firstName);
            assertEquals("Cleese", user.lastName);
            assertEquals("password", user.password);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUserPOST() {
        String result = ninjaTestBrowser.makeRequest(serverAddress + "/user");
        try {
            User resultParent = objectMapper.readValue(result, User.class);
            assertEquals("johncleese", resultParent.username);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testBudgetGET() {
        int id = 1;
        String result = ninjaTestBrowser.makeRequest(serverAddress + "/budget/" + id);
        try {
            Budget budget = objectMapper.readValue(result, Budget.class);
            assertEquals(1, budget.id);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testBudgetGETInvalid() {
        int id = -1;
        String result = ninjaTestBrowser.makeJsonRequest(serverAddress + "/budget/" + id);

        // Strip quotes from result string
        assertEquals(id + " is less than 1", result.replaceAll("^\"|\"$", ""));
    }

}