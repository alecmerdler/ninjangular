package services;

import models.Budget;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


/**
 * Created by alec on 7/16/16.
 */
public class BudgetServiceImplTest {
    BudgetService budgetService;

    @Before
    public void beforeEach() {
        budgetService = new BudgetServiceImpl();

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
        }
        catch (Exception e) {
            fail("Should not throw exception");
        }
    }

    @Test
    public void testRetrieveBudgetInvalidId() {
        int id = -1;
        try {
            Budget budget = budgetService.retrieveBudget(id);
            fail("Should have thrown exception");
        }
        catch (Exception e) {
            assertEquals(id + " is less than 1", e.getMessage());
        }
    }

}
