package com.project.periodental.user.application.persistence;

import com.project.periodental.user.application.persistence.dao.LoginDAO;
import com.project.periodental.user.domain.user.User;
import com.project.periodental.user.usecase.gateway.LoginDsGateway;
import io.activej.inject.annotation.Inject;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class DSLogin implements LoginDsGateway {

    private final LoginDAO loginDAO;

    @Inject
    public DSLogin(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public boolean exitsByName(String username) {
        return loginDAO.exitsByName(username);
    }

    @Override
    public String getEncriptedPasswordByUsername(String username) {
        return loginDAO.findEncriptedPasswordByUsername(username);
    }

    @Override
    public User signUp(String username, String password) {
        return loginDAO.singUp(username, password);
    }
}
