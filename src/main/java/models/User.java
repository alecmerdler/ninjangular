package models;

/**
 * Created by alec.merdler on 7/7/16.
 */
public class User extends Model {
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public User parent;

    private int maxPasswordLength = 20;

    private User() {}

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public void changePassword(String newPassword) {
        if (newPassword.length() < maxPasswordLength) {
            this.password = newPassword;
        }
    }


}
