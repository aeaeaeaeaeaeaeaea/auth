package ru.ae.authform.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {


    @Size(min = 2, max = 30, message = "size of the login should be between 2 and 30 characters")
    private String login;

    @NotEmpty(message = "password shouldn't be empty")
    @Size(min = 2, max = 100, message = "size of the password should be between 8 and 100 characters")
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
