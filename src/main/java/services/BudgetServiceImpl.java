package services;

import models.Budget;
import models.User;

/**
 * Created by alec on 7/16/16.
 */
public class BudgetServiceImpl implements BudgetService {
    User user;
    int id;
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

    UserFactoryImpl userFactory;

    public BudgetServiceImpl() {
        this.userFactory = new UserFactoryImpl();

        this.user = this.setUser();
        this.id = 1;
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

    public Budget retrieveBudget(int id) throws Exception {
        if (id < 1) {
            throw new Exception(id + " is less than 1");
        }
        return new Budget(
                user,
                id,
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
    }

    private User setUser() {
        return this.userFactory.createDefaultUser();
    }
}
