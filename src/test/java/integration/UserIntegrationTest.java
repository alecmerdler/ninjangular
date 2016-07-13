package integration;

import models.User;
import ninja.NinjaTest;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by alec.merdler on 7/12/16.
 */
public class UserIntegrationTest extends NinjaTest {
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
            assertEquals("johncleese", user.parent.username);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUserParentGET() {
        String result = ninjaTestBrowser.makeRequest(serverAddress + "/user/parent");
        try {
            User parent = objectMapper.readValue(result, User.class);
            assertEquals("parent", parent.username);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUserPost() {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("username", "bob");
        String result = ninjaTestBrowser.postJson(serverAddress + "/user", userMap);
        try {
            User resultParent = objectMapper.readValue(result, User.class);
            assertEquals("bob", resultParent.username);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testExternalAPI() {
        String result = ninjaTestBrowser.makeRequest(agbizAddress + "/allocate/api/business_data/1/");
        try {
            HashMap<String, String> resultMap = objectMapper.readValue(result, HashMap.class);
            assertEquals(1, resultMap.get("id"));
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

}