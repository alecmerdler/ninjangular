package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;


/**
 * Created by alec.merdler on 7/15/16.
 */
public class Budget extends Model {
    User user;
    public int id;
    public String title;
    public String notes;
    public String enterprise;
    public String descriptor1;
    public String descriptor2;
    public String descriptor3;
    public String descriptor4;
    public String descriptor5;
    public String descriptor6;
    public String market;

    public String state;
    public String region;

    @JsonProperty("time_unit")
    public String timeUnit;

    @JsonProperty("time_value")
    public int timeValue;

    @JsonProperty("farm_unit")
    public String farmUnit;

    @JsonProperty("farm_unit_quantity")
    public int farmUnitQuantity;

    @JsonProperty("total_costs")
    public int totalCosts;

    @JsonProperty("total_variable_costs")
    public int totalVariableCosts;

    @JsonProperty("total_fixed_costs")
    public int totalFixedCosts;

    @JsonProperty("total_general_costs")
    public int totalGeneralCosts;

    @JsonProperty("total_income_less_variable_costs")
    public int totalIncomeLessVariableCosts;

    @JsonProperty("total_gross_returns")
    public int totalGrossReturns;

    public int profit;

    @JsonProperty("breakeven_yield")
    public int breakevenYield;

    @JsonProperty("breakeven_price")
    public int breakevenPrice;

    @JsonProperty("total_yields")
    public int totalYields;

    // FIXME: create pojo representations of these models
    @JsonProperty("cost_items")
    public HashMap<String, String>[] costItems;

    @JsonProperty("income_items")
    public HashMap<String, String>[] incomeItems;


    private Budget() {}

    public Budget(
            User user,
            int id,
            String title,
            String notes,
            String enterprise,
            String descriptor1,
            String descriptor2,
            String descriptor3,
            String descriptor4,
            String descriptor5,
            String descriptor6,
            String market,

            String state,
            String region,

            String timeUnit,
            int timeValue,
            String farmUnit,
            int farmUnitQuantity
    ) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.notes = notes;
        this.enterprise = enterprise;
        this.descriptor1 = descriptor1;
        this.descriptor2 = descriptor2;
        this.descriptor3 = descriptor3;
        this.descriptor4 = descriptor4;
        this.descriptor5 = descriptor5;
        this.descriptor6 = descriptor6;
        this.market = market;
        this.state = state;
        this.region = region;
        this.timeUnit = timeUnit;
        this.timeValue = timeValue;
        this.farmUnit = farmUnit;
        this.farmUnitQuantity = farmUnitQuantity;
    }

}

