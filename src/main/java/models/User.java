package models;

/**
 * Created by alec.merdler on 7/7/16.
 */
public class User {
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public User parent;

    private int maxPasswordLength = 20;
    private String catchphrase;

    public User() {
        this.firstName = "John";
        this.lastName = "Cleese";
        this.username = "johncleese";
        this.password = "password";
        this.catchphrase = "yo";
    }

    public void changePassword(String newPassword) {
        if (newPassword.length() < maxPasswordLength) {
            this.password = newPassword;
        }
    }

    public String sayCatchphrase() {
        return this.catchphrase;
    }

    public void giveParent(User parent) {
        this.parent =  parent;
    }
}
