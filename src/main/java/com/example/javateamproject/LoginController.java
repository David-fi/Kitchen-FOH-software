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

import java.sql.*;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    public static Integer id;
    public static String username;
    public static String type;
    private String dbID;
    private String dbUsername;
    private String dbType;
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void handleLoginButton(ActionEvent event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();
        try{
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT UserID, Username, UserType " +
                    "FROM Users " +
                    "WHERE Username = ? AND Password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dbID = resultSet.getString("UserID");
                dbUsername = resultSet.getString("Username");
                dbType = resultSet.getString("UserType");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources in the finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Log or handle the exception if closing resources fails
                e.printStackTrace();
            }
        }
            if ((dbID != null && dbUsername != null && dbType != null)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            username = dbUsername;
            type = dbType;
            id = Integer.parseInt(dbID);
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
