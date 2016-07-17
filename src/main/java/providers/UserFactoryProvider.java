package providers;

import services.UserFactory;

/**
 * Created by alec.merdler on 7/17/16.
 */
public interface UserFactoryProvider {
    UserFactory createUserFactory();
}
