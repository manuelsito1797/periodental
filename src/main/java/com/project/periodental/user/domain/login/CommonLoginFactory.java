package com.project.periodental.user.domain.login;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class CommonLoginFactory implements LoginFactory {
    @Override
    public Login create(String user, String password) {
        return new Login(user, password);
    }
}
