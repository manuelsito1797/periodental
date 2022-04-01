package com.project.periodental.user.usecase.interactor;

import com.project.periodental.adapter.security.EncryptionAdapter;
import com.project.periodental.generics.presenter.Presenter;
import com.project.periodental.generics.usecase.UseCaseWithParam;
import com.project.periodental.user.domain.login.LoginFactory;
import com.project.periodental.user.usecase.gateway.LoginDsGateway;
import com.project.periodental.user.usecase.model.LoginRequestModel;
import com.project.periodental.user.usecase.model.UserResponseModel;

import java.security.GeneralSecurityException;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class SignUp extends UseCaseWithParam<UserResponseModel,LoginRequestModel> {

    private final LoginDsGateway loginDsGateway;
    private final Presenter<UserResponseModel> presenter;
    private final LoginFactory loginFactory;
    private final EncryptionAdapter encryptionAdapter;

    public SignUp(LoginDsGateway loginDsGateway, Presenter<UserResponseModel> presenter, LoginFactory loginFactory,
                  EncryptionAdapter encryptionAdapter) {
        this.loginDsGateway = loginDsGateway;
        this.presenter = presenter;
        this.loginFactory = loginFactory;
        this.encryptionAdapter = encryptionAdapter;
    }

    @Override
    public UserResponseModel execute(LoginRequestModel requestModel) throws RuntimeException {
        if(!requestModel.usernameIsValid()) {
            return presenter.prepareFailView("El nombre de usuario está vacío. Favor ingrese un nombre de usuario.");
        }

        if(!loginDsGateway.exitsByName(requestModel.getUsername())) {
            return presenter.prepareFailView("El usuario " + requestModel.getUsername() + " no existe.");
        }

        var login = loginFactory.create(requestModel.getUsername(), requestModel.getPassword());
        if(!login.passwordIsValid()) {
            return presenter.prepareFailView("La contraseña debe poseer 4 caracteres o más.");
        }

        var encrypted = loginDsGateway.getEncriptedPasswordByUsername(requestModel.getUsername());
        String decrypted = null;
        try {
            decrypted = encryptionAdapter.decrypt(encrypted);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        if(!requestModel.getPassword().equals(decrypted))  {
            return presenter.prepareFailView("Error al intentar iniciar sesión.");
        }

        var user = loginDsGateway.signUp(requestModel.getUsername(), encrypted);
        var response = new UserResponseModel(
                user.getId(), user.getName(), user.getLastName(), user.getPhone(), user.getEmail(),
                user.getUsername(), user.getPassword(), user.getCreatedBy(), user.getCreationDate(), user.isStatus()
        );

        return presenter.prepareSuccessView(response);
    }
}
