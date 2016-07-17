package integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Budget;
import models.User;
import ninja.NinjaTest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by alec.merdler on 7/12/16.
 */
public class IntegrationTest extends NinjaTest {
    String serverAddress;
    String agbizAddress;
    String budgetsResource;
    ObjectMapper objectMapper;

    @Before
    public void beforeEach() {
        objectMapper = new ObjectMapper();
        serverAddress = getServerAddress();
        budgetsResource = serverAddress + "/budgets";

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
    public void testBudgetGETValid() {
        int id = 1;
        String result = ninjaTestBrowser.makeRequest(budgetsResource + "/" + id);
        try {
            Budget budget = objectMapper.readValue(result, Budget.class);
            assertEquals(1, budget.id);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testBudgetGETNegativeID() {
        int id = -1;
        String result = ninjaTestBrowser.makeJsonRequest(budgetsResource + "/" + id);
        try {
            HashMap<String, String> resultMap = objectMapper.readValue(result, HashMap.class);
            assertEquals("Oops. The requested route cannot be found.", resultMap.get("text"));
        }
        catch (IOException e) {
            fail("Should not throw exception");
        }
    }

    @Test
    public void testBudgetGETNonexistentID() {
        int id = 20000;
        String result = ninjaTestBrowser.makeJsonRequest(budgetsResource + "/" + id);

        // Strip quotes from result string
        assertEquals("Budget with id could not be found", result.replaceAll("^\"|\"$", ""));
    }

}