package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class DeleteRecipeController {
    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
