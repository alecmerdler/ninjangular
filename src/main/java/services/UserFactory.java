package services;

import models.User;

/**
 * Created by alec on 7/16/16.
 */
public interface UserFactory {
    public User createDefaultUser();

    public User createUser(String firstName, String lastName, String username, String password);
}
