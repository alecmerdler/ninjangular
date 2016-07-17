package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import models.Budget;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alec on 7/16/16.
 */
public class BudgetServiceImpl implements BudgetService {
    private UserFactory userFactory;
    private CloseableHttpClient closeableHttpClient;
    private String agbizAddress;
    private ObjectMapper objectMapper;

    public BudgetServiceImpl(UserFactory userFactory, CloseableHttpClient closeableHttpClient) {
        this.closeableHttpClient = closeableHttpClient;
        this.userFactory = userFactory;
        this.objectMapper = new ObjectMapper();
        this.agbizAddress = "http://agbizdev.cosine.oregonstate.edu";
    }

    public Budget retrieveBudget(int id) throws Exception {
        if (id < 1) {
            throw new Exception(id + " is less than 1");
        }
        try {
            CloseableHttpResponse response = executeRetrieve(id);
            return parseResponse(response);
        }
        catch (Exception e) {
            throw e;
        }
    }

    private CloseableHttpResponse executeRetrieve(int id) throws IOException {
        HttpGet httpGet = new HttpGet(agbizAddress + "/budget/api/budgets/" + id + "/");
        return closeableHttpClient.execute(httpGet);
    }

    private Budget parseResponse(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        InputStream stream = entity.getContent();
        try {
            Budget budget = objectMapper.readValue(stream, Budget.class);
            return budget;
        }
        catch (UnrecognizedPropertyException e) {
            throw new IOException("Budget with id could not be found");
        }
        finally {
            response.close();
        }
    }
}
