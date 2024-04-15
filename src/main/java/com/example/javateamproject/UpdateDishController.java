package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateDishController {
    public Connection connection;

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public boolean editDishes(int DishID, String newDishesName) {
        String sql = "UPDATE Dish SET Name = ? WHERE DishID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newDishesName);
            statement.setInt(2, DishID);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
//    public void HandleUpdateDish(){
//        int updateDishEnterName=Integer.parseInt(UpdateDishEnterName.getText());
//        String updateDishEnterDishID=UpdateDishEnterDishID.getText();
//        editDishes(updateDishEnterName, updateDishEnterDishID);
//    }
}
