package com.example.javateamproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
    @FXML

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void handleLoginButton(ActionEvent event) {
        try {
            showAlertWindow("Login Failed", "Invalid username or password.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAlertWindow(String title, String message) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("alert-page.fxml"));
        Parent root = loader.load();
        AlertController controller = loader.getController();
        controller.setMessage(message);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static void clearLogin(){
        // Called whenever sign out is pressed from another scene
    }

}
