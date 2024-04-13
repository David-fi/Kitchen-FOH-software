package com.example.javateamproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
    public static Integer id;
    public static String username;
    public static String type;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void handleLoginButton(ActionEvent event) {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();
        if (enteredUsername.equals("your_username") && enteredPassword.equals("your_password")) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            username = "test";
            type = "Sous";
            id = 1;
        } else {
            try {
                showAlertWindow( "Invalid username or password.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showAlertWindow (String message) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("alert-page.fxml"));
        Parent root = loader.load();
        AlertController controller = loader.getController();
        controller.setMessage(message);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static void clearLogin(){
        id = null;
        username = null;
        type = null;
    }
}
