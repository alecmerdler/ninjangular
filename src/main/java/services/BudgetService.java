package services;

import models.Budget;

/**
 * Created by alec on 7/16/16.
 */
public interface BudgetService {
    Budget retrieveBudget(int id) throws Exception;
}
