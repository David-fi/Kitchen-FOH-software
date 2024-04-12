package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class LoginController {
    private static Integer id;
    private static String username;
    private static String type;

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public static void clearLogin(){
        id = null;
        username = null;
        type = null;
    }
}
