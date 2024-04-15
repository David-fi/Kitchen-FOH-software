package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteMenuController {
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password ="3h058sqxPaI";
    public Connection connection;
    @FXML
    private TextArea DeleteMenuEnterMenuID;

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void removeMenuFromDatabase(int menuId) {

        try {Connection connection=null;
             connection= DriverManager.getConnection(url,user,password);
            String sql = "DELETE FROM Menus WHERE MenuID=?";
             PreparedStatement statement = connection.prepareStatement(sql);{
                statement.setInt(1, menuId);
                int rowsDeleted = statement.executeUpdate();
                if(rowsDeleted>0){
                    System.out.println("Delete Menu Successfully");
                }else{
                    System.out.println("Delete Menu Failed");
                }

            }
        } catch (SQLException ex) {
            ex.getMessage();

        }
    }
    public void HandleDeleteMenu(){
        int deleteMenuEnterMenuID=Integer.parseInt(DeleteMenuEnterMenuID.getText());
        removeMenuFromDatabase(deleteMenuEnterMenuID);
    }

}
