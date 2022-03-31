package com.project.periodental.user.usecase.model;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class LoginRequestModel {

    private String username;
    private String password;

    public LoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean usernameIsValid() {
        return !username.isEmpty();
    }
}
