package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class IndividualOrderController {
    @FXML
    private Label dishLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label orderIDLabel;
    @FXML
    private TextArea specialRequestArea;
    @FXML
    private TextArea dietaryArea;

    public void handleCompletedButton(ActionEvent event) {

    }
    public void setDish(String dish) {
        dishLabel.setText(dish);
    }
    public void setQuantity(String quantity) {
        dishLabel.setText(quantity);
    }
    public void setOrderID(String orderID) {
        dishLabel.setText(orderID);
    }
}
