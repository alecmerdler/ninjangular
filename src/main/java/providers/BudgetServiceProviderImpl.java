package providers;

import com.google.inject.Inject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import services.BudgetService;
import services.BudgetServiceImpl;
import services.UserFactory;

/**
 * Created by alec on 7/16/16.
 */
public class BudgetServiceProviderImpl implements BudgetServiceProvider {
    CloseableHttpClient closeableHttpClient;
    UserFactory userFactory;

    // UserFactory is not used by BudgetService, but leaving here to demonstrate Dependency Injection complexities
    @Inject
    public BudgetServiceProviderImpl(UserFactory userFactory) {
        this.closeableHttpClient = HttpClients.createDefault();
        this.userFactory = userFactory;
    }

    public BudgetService createBudgetService() {
        return new BudgetServiceImpl(this.userFactory, this.closeableHttpClient);
    }
}
