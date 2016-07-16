package mocks.services;

import models.User;
import services.UserFactory;

/**
 * Created by alec on 7/16/16.
 */
public class UserFactoryMock implements UserFactory {
    private String defaultFirstName;
    private String defaultLastName;
    private String defaultUsername;
    private String defaultPassword;

    public UserFactoryMock() {
        this.defaultFirstName = "John";
        this.defaultLastName = "Cleese";
        this.defaultUsername = "johncleese";
        this.defaultPassword = "password";
    }

    public User createDefaultUser() {
        return new User(this.defaultFirstName, this.defaultLastName, this.defaultUsername, this.defaultPassword);
    }

    public User createUser(String firstName, String lastName, String username, String password) {
        User user = new User(firstName, lastName, username, password);

        return user;
    }
}
