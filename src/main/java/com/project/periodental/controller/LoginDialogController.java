package com.project.periodental.controller;

import com.project.periodental.adapter.di.DIFactory;
import com.project.periodental.adapter.di.DIType;
import com.project.periodental.user.usecase.interactor.SignUp;
import com.project.periodental.user.usecase.model.LoginRequestModel;
import com.project.periodental.user.usecase.model.UserResponseModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author djimenez on 1/4/2022
 * periodental
 */
public class LoginDialogController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage dialogStage;

    private LoginSuccessListener listener;

   public interface LoginSuccessListener {
        void onSuccessLogin();
    }

    public void setLoginSuccessListener(LoginSuccessListener listener) {
        this.listener = listener;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {}

    /**
     * Establecer escenario para este dialog
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Establecer credenciales de usuario.
     */
    @FXML
    public void handleSignUp() {
        var request = new LoginRequestModel(usernameField.getText(), passwordField.getText());
        var singUp = DIFactory.getAdapter(DIType.ACTIVEJ).getInstance(SignUp.class);
        UserResponseModel user = null;
        try {
            user = singUp.execute(request);
            listener.onSuccessLogin();
            dialogStage.close();
        } catch (RuntimeException e) {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Datos Inválidos");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Error al iniciar sesión");
            alert.showAndWait();
        }
    }

    /**
     * Cerra cuando el usuario presiona cancelar
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
