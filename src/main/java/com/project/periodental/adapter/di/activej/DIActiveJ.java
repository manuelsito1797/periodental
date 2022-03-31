package com.project.periodental.adapter.di.activej;

import com.project.periodental.adapter.converter.modelmapper.EntityDtoConverter;
import com.project.periodental.adapter.db.DBFactory;
import com.project.periodental.adapter.db.IDBAdapter;
import com.project.periodental.adapter.di.IDIAdapter;
import com.project.periodental.adapter.security.EncryptionAdapter;
import com.project.periodental.adapter.security.basic.CipherAdapter;
import com.project.periodental.generics.presenter.Presenter;
import com.project.periodental.user.application.formatter.LoginPresenter;
import com.project.periodental.user.application.persistence.DSLogin;
import com.project.periodental.user.application.persistence.dao.LoginDAO;
import com.project.periodental.user.domain.login.CommonLoginFactory;
import com.project.periodental.user.domain.login.LoginFactory;
import com.project.periodental.user.domain.user.CommonUserFactory;
import com.project.periodental.user.domain.user.UserFactory;
import com.project.periodental.user.usecase.gateway.LoginDsGateway;
import com.project.periodental.user.usecase.interactor.SignUp;
import com.project.periodental.user.usecase.model.UserResponseModel;
import io.activej.inject.Injector;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import io.activej.inject.module.Module;
import org.modelmapper.ModelMapper;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class DIActiveJ implements IDIAdapter {

    Module module = new AbstractModule() {
        // Adapter
        @Provides
        ModelMapper modelMapper() {
            return new ModelMapper();
        }

        @Provides
        EntityDtoConverter converter(ModelMapper modelMapper) {
            return new EntityDtoConverter(modelMapper);
        }

        @Provides
        UserFactory userFactory() {
            return new CommonUserFactory();
        }

        @Provides
        IDBAdapter dbAdapter() {
            return DBFactory.getAdapter();
        }

        // SignUp
        @Provides
        LoginDAO loginDAO(IDBAdapter idbAdapter) {
            return new LoginDAO(idbAdapter);
        }

        @Provides
        LoginDsGateway dsLogin(LoginDAO loginDAO) {
            return new DSLogin(loginDAO);
        }

        @Provides
        Presenter<UserResponseModel> presenter() {
            return new LoginPresenter();
        }

        @Provides
        LoginFactory loginFactory() {
            return new CommonLoginFactory();
        }

        @Provides
        EncryptionAdapter encryptionAdapter() {
            return new CipherAdapter();
        }

        @Provides
        SignUp signUp(LoginDsGateway loginDsGateway, Presenter<UserResponseModel> presenter,LoginFactory loginFactory,
                      EncryptionAdapter encryptionAdapter) {
            return new SignUp(loginDsGateway, presenter, loginFactory, encryptionAdapter);
        }
    };

    @Override
    public <T> T getInstance(Class<T> clazz) {
        return Injector.of(module).getInstance(clazz);
    }
}
