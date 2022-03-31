package com.project.periodental.user.application.formatter;

import com.project.periodental.generics.presenter.Presenter;
import com.project.periodental.user.usecase.model.UserResponseModel;

import java.util.List;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class LoginPresenter implements Presenter<UserResponseModel> {
    @Override
    public List<UserResponseModel> prepareAllSuccessView(List<UserResponseModel> responses) {
        return responses;
    }

    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel response) {
        return response;
    }

    @Override
    public UserResponseModel prepareFailView(String error) {
        throw new RuntimeException(error);
    }
}
