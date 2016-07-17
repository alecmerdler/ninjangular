package mocks.services;

import models.Budget;
import models.User;
import services.BudgetService;
import services.UserFactoryImpl;

/**
 * Created by alec on 7/16/16.
 */
public class BudgetServiceMock implements BudgetService {
    User user;
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

    public BudgetServiceMock() {
        this.userFactory = new UserFactoryImpl();

        this.user = this.setUser();
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
                this.user,
                id,
                this.title,
                this.notes,
                this.enterprise,
                this.descriptor1,
                this.descriptor2,
                this.descriptor3,
                this.descriptor4,
                this.descriptor5,
                this.descriptor6,
                this.market,
                this.state,
                this.region,
                this.timeUnit,
                this.timeValue,
                this.farmUnit,
                this.farmUnitQuantity
        );
    }

    public Budget combine(int[] ids) throws Exception {
        if (ids.length < 2) {
            throw new Exception("Need to be supplied with 2 or more id's");
        }
        return new Budget(
                this.user,
                ids[0],
                this.title,
                this.notes,
                this.enterprise,
                this.descriptor1,
                this.descriptor2,
                this.descriptor3,
                this.descriptor4,
                this.descriptor5,
                this.descriptor6,
                this.market,
                this.state,
                this.region,
                this.timeUnit,
                this.timeValue,
                this.farmUnit,
                this.farmUnitQuantity
        );
    }

    private User setUser() {
        return this.userFactory.createDefaultUser();
    }



}
