package com.project.periodental.user.usecase.model;

import java.sql.Timestamp;

/**
 * @author djimenez on 30/3/2022
 * periodental
 */
public class UserResponseModel {

    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String user;
    private String password;
    private int createdBy;
    private Timestamp creationDate;
    private boolean status;

    public UserResponseModel(int id, String name, String lastName, String phone, String email,
                             String user, String password, int createdBy, Timestamp creationDate, boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.user = user;
        this.password = password;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setStatus(boolean status) {
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

    public String getUser() {
        return user;
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

    @Override
    public String toString() {
        return "UserResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", status=" + status +
                '}';
    }
}
