package com.project.periodental.user.domain.user;

import java.sql.Timestamp;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class User {

    private final int id;
    private final String name;
    private final String lastName;
    private final String phone;
    private final String email;
    private final String username;
    private final String password;
    private final Timestamp creationDate;
    private final int createdBy;
    private final boolean status;

    public User(int id, String name, String lastName, String phone, String email,
                String username, String password, int createdBy, Timestamp creationDate, boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean passwordIsValid() {
        return !password.isEmpty() && password.length() >=4;
    }
}
