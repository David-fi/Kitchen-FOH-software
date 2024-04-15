package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class TableOrderController {
    @FXML
    private Label tableNumberLabel;
    @FXML
    private ScrollPane orderPane;
    @FXML
    private VBox orderBox;
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";

    private Timer timer;
    public void initialize() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getOrders();
            }
        }, 15 * 1000, 15 * 1000);
    }

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void setTableNumber(String tableNumber) {
        tableNumberLabel.setText(tableNumber);
    }
    public void getOrders(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String tableID = tableNumberLabel.getText();
        orderBox.getChildren().clear();
        try {
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT Orders.OrderID, Dishes.Name AS DishName, OrderDishes.Quantity, Orders.CustomerDietaryInfo, Orders.SpecialRequests " +
                    "FROM Orders " +
                    "JOIN OrderDishes ON Orders.OrderID = OrderDishes.OrderID " +
                    "JOIN Dishes ON OrderDishes.DishID = Dishes.DishID " +
                    "WHERE Orders.TableID = ? AND Orders.Status = 'Pending'";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tableID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String orderId = resultSet.getString("OrderID");
                String dishName = resultSet.getString("DishName");
                String quantity = resultSet.getString("Quantity");
                String request = resultSet.getString("SpecialRequests");
                String dietary = resultSet.getString("CustomerDietaryInfo");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("order.fxml"));
                Parent root = loader.load();
                IndividualOrderController controller = loader.getController();
                controller.setOrderID(orderId);
                controller.setDish(dishName);
                controller.setQuantity(quantity);
                controller.setRequest(request);
                controller.setDietary(dietary);
                orderBox.getChildren().add(root);
            }
            orderPane.setContent(orderBox);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
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
                e.printStackTrace();
            }
        }
    }
}
