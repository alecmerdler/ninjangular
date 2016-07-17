package services;

import models.Budget;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


/**
 * Created by alec on 7/16/16.
 */
public class BudgetServiceImplTest {
    BudgetService budgetService;

    UserFactory userFactoryMock;
    CloseableHttpClient closeableHttpClientMock;

    @Before
    public void beforeEach() {
        userFactoryMock = mock(UserFactory.class);
        // FIXME: setup mocking
//        closeableHttpClientMock = mock(CloseableHttpClient.class);
        closeableHttpClientMock = HttpClients.createDefault();
        budgetService = new BudgetServiceImpl(userFactoryMock, closeableHttpClientMock);
    }

    @Test
    public void testCreateBudgetService() {
        assertThat(budgetService, instanceOf(BudgetService.class));
    }

    @Test
    public void testRetrieveBudget() {
        int id = 1;
        try {
            Budget budget = budgetService.retrieveBudget(id);
            assertEquals(id, budget.id);
//            verify(closeableHttpClientMock.execute(any(HttpGet.class)));
        }
        catch (Exception e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void testRetrieveBudgetNegativeID() {
        int id = -1;
        try {
            budgetService.retrieveBudget(id);
            fail("Should have thrown exception");
        }
        catch (Exception e) {
            assertEquals(id + " is less than 1", e.getMessage());
        }
    }

    @Test
    public void testRetrieveBudgetNonexistentID() {
        int id = 200000;
        try {
            budgetService.retrieveBudget(id);
            fail("Should have thrown exception");
        }
        catch (Exception e) {
            assertEquals("Budget with id could not be found", e.getMessage());
        }
    }

    @Test
    public void testCombineBudgetsSingle() {
        int ids[] = {1};
        try {
            budgetService.combine(ids);
            fail("Should have thrown exception when supplied array with less than 2 id's");
        }
        catch (Exception e) {
            assertEquals("Need to be supplied with 2 or more id's", e.getMessage());
        }
    }

}
