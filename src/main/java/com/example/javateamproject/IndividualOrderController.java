package com.example.javateamproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";
    public void handleCompletedButton(ActionEvent event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE Orders SET Status = 'Completed' WHERE OrderID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderIDLabel.getText());
            preparedStatement.executeUpdate();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void setDish(String dish) {
        dishLabel.setText(dish);
    }
    public void setQuantity(String quantity) {
        quantityLabel.setText("Quantity:" + quantity);
    }
    public void setOrderID(String orderID) {
        orderIDLabel.setText(orderID);
    }
    public void setRequest(String specialRequest) {
        specialRequestArea.setText(specialRequest);
    }
    public void setDietary(String dietary) {
        dietaryArea.setText(dietary);
    }
}

