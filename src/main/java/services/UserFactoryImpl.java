package services;

import models.User;

/**
 * Created by alec.merdler on 7/8/16.
 */
public class UserFactoryImpl implements UserFactory {
    String defaultFirstName;
    String defaultLastName;
    String defaultUsername;
    String defaultPassword;

    public UserFactoryImpl() {
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
