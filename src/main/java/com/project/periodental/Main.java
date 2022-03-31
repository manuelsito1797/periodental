package com.project.periodental;

import com.project.periodental.adapter.di.DIFactory;
import com.project.periodental.adapter.di.DIType;
import com.project.periodental.user.usecase.interactor.SignUp;
import com.project.periodental.user.usecase.model.LoginRequestModel;

/**
* @author djimenez on 30/3/2022
* periodental
*/
public class Main {

    public static void main(String[] args) {
        SignUp signUp = DIFactory.getAdapter(DIType.ACTIVEJ).getInstance(SignUp.class);
        var user = signUp.execute(new LoginRequestModel("dhelarius", "1234"));
        System.out.println(user.toString());
    }
}
