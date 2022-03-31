package com.project.periodental.user.usecase.gateway;

import com.project.periodental.user.domain.user.User;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public interface LoginDsGateway {

    boolean exitsByName(String username);

    String getEncriptedPasswordByUsername(String username);

    User signUp(String username, String password);
}
