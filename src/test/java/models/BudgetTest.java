package models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by alec.merdler on 7/15/16.
 */
public class BudgetTest {
    String title;
    String notes;
    String enterprise;
    String descriptor1;
    String descriptor2;
    String descriptor3;
    String descriptor4;
    String descriptor5;
    String descriptor6;
    String market ;

    String state;
    String region;

    String timeUnit;
    int timeValue;
    String farmUnit;
    int farmUnitQuantity;


    @Before
    public void beforeEach() {
        this.title = "My Budget";
        this.notes = "My notes here";
        this.enterprise = "";
        this.descriptor1 = "";
        this.descriptor2 = "";
        this.descriptor3 = "";
        this.descriptor4 = "";
        this.descriptor5 = "";
        this.descriptor6 = "";
        this.market = "GMO";

        this.state = "OR";
        this.region = "Beaverton";

        this.timeUnit = "years";
        this.timeValue = 2;
        this.farmUnit = "acres";
        this.farmUnitQuantity = 20;
    }

    @Test
    public void testCreateNewBudget() {
        User user = new User();
        Budget budget = new Budget(
                user,
                title,
                notes,
                enterprise,
                descriptor1,
                descriptor2,
                descriptor3,
                descriptor4,
                descriptor5,
                descriptor6,
                market,
                state,
                region,
                timeUnit,
                timeValue,
                farmUnit,
                farmUnitQuantity
            );

        assertEquals(user, budget.user);
        assertEquals(title, budget.title);
        assertEquals(notes, budget.notes);
        assertEquals(descriptor1, budget.descriptor1);
        assertEquals(descriptor2, budget.descriptor2);
        assertEquals(descriptor3, budget.descriptor3);
        assertEquals(descriptor4, budget.descriptor4);
        assertEquals(descriptor5, budget.descriptor5);
        assertEquals(descriptor6, budget.descriptor6);
        assertEquals(market, budget.market);
        assertEquals(state, budget.state);
        assertEquals(region, budget.region);
        assertEquals(timeUnit, budget.timeUnit, timeUnit);
        assertEquals(timeValue, budget.timeValue, timeValue);
        assertEquals(farmUnit, budget.farmUnit, farmUnit);
        assertEquals(farmUnitQuantity, budget.farmUnitQuantity);
        assertThat(budget, instanceOf(Model.class));

    }
}
