package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecipeController {
    public Connection connection;
    @FXML
    private TextArea DeleteRecipeEnterRecipeID;
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password ="3h058sqxPaI";

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void removeRecipeFromDatabase(int RecipeId) {

        try {
            Connection connection = null;
            connection = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM Recipes WHERE RecipeID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setInt(1, RecipeId);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Delete Recipe Successfully");
                }else {
                    System.out.println("Delete Recipe Failed");
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();

        }
    }
    public void HandleDeleteRecipe(){
        int deleteRecipeEnterRecipeID=Integer.parseInt(DeleteRecipeEnterRecipeID.getText());
        removeRecipeFromDatabase(deleteRecipeEnterRecipeID);
    }

}
