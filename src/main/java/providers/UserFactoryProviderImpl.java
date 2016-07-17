package providers;

import com.google.inject.Inject;
import services.UserFactory;

/**
 * Created by alec.merdler on 7/17/16.
 */
public class UserFactoryProviderImpl implements UserFactoryProvider {
    private UserFactory userFactory;

    @Inject
    public UserFactoryProviderImpl(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public UserFactory createUserFactory() {
        return this.userFactory;
    }
}
