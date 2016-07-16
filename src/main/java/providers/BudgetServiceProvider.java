package providers;

import services.BudgetService;

/**
 * Created by alec on 7/16/16.
 */
public interface BudgetServiceProvider {
    BudgetService createBudgetService();
}
