package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateMenuController {
    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void switchToAddDishMenu(ActionEvent event) throws IOException {
        // Switches to review page.
        Parent root = FXMLLoader.load(getClass().getResource("add-dish-menu-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRemoveDishMenu(ActionEvent event) throws IOException {
        // Switches to review page.
        Parent root = FXMLLoader.load(getClass().getResource("remove-dish-menu-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToReview(ActionEvent event) throws IOException {
        // Switches to review page.
        Parent root = FXMLLoader.load(getClass().getResource("review-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
