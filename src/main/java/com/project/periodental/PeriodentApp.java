package com.project.periodental;

import com.project.periodental.controller.LoginDialogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author djimenez on 1/4/2022
 * periodental
 */
public class PeriodentApp extends Application {

    private Stage stage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("Periodental");

        showLoginDialog();
    }

    private void showLoginDialog() {
        try {
            // Load login dialog from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PeriodentApp.class.getResource("view/login-dialog.fxml"));
            AnchorPane loginDialog = (AnchorPane) loader.load();

            // Crear dialog.
            var dialogStage = new Stage();
            dialogStage.setTitle("Iniciar Sesión");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(loginDialog);
            dialogStage.setScene(scene);

            // Establecer dialog
            LoginDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLoginSuccessListener(this::initRootLayout);

            // Mostrar dialog de inicio de sesión
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize root layout.
     */
    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PeriodentApp.class.getResource("view/root-layout.fxml"));

            // Show the scene containing the root layout.
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
