package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.*;

public class DeleteDishController {
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password ="3h058sqxPaI";
    public Connection connection;
    @FXML
    private TextArea DeleteDishEnterDishID;

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void removeDishesFromDatabase(int DishesId) {

        try {Connection connection = null;
             connection=DriverManager.getConnection(url,user,password) ;
        String sql = "DELETE FROM Dishes WHERE DishID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);{
                statement.setInt(1, DishesId);
                int rowsDeleted = statement.executeUpdate();
                if(rowsDeleted>0) {
                    System.out.println("Dish deleted successfully");
                }else{
                    System.out.println("Dish deletion failed");
                }
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void HandleDeleteDish(){
        int deleteDishEnterDishID=Integer.parseInt(DeleteDishEnterDishID.getText());
        removeDishesFromDatabase(deleteDishEnterDishID);
    }

}
