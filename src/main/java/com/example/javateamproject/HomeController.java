package com.example.javateamproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeController extends BaseController{
    @FXML
    Button signinButton;
    public void showLoginWindow() throws IOException {
        if (signinButton.getText().equals("Sign in")){
            Parent root = FXMLLoader.load(getClass().getResource("sign-in.fxml"));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        else if (signinButton.getText().equals("Sign out")){
            LoginController.clearLogin();
        }
    }

}
