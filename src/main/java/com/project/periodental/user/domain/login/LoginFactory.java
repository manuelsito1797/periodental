package com.project.periodental.user.domain.login;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public interface LoginFactory {
    Login create(String user, String password);
}
