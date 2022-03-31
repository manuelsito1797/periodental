package com.project.periodental.user.domain.user;

import java.sql.Timestamp;

/**
 * @author djimenez on 30/3/2022
 * periodental
 */
public class CommonUserFactory implements UserFactory {
    @Override
    public User create(int id, String name, String lastName, String phone, String email, String user,
                       String password, int createdBy, Timestamp creationDate, boolean status) {
        return new User(id, name, lastName, phone, email, user,
                password, createdBy, creationDate, status);
    }
}
