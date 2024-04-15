//package com.example.javateamproject;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.Node;
//import javafx.stage.Stage;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//public Connection connection;
//@FXML
//private CreateDishEnterDishID;
//@FXML
//private CreateDishEnterDishName;
//@FXML
//private createDishEnterRecipeID
//@FXML
//private createDishEnterPhotoPath;
//@FXML
//private createDisheEnterPre
//public class UpdateRecipeController {
//    public void handleCloseButton(ActionEvent event) {
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.close();
//    }
//}
//public void handleSave() {
//    int createDishEnterDishID = Integer.parseInt(CreateDishEnterDishID.getText());// Get the text from TextArea
//    String createDishEnterDishName = CreateDishEnterDishName.getText();
//    int createDishEnterRecipeID = Integer.parseInt(CreateDishEnterRecipeID.getText());
//    String createDishEnterPhotoPath = CreateDishEnterPhotoPath.getText();
//    int createDishEnterPreparationTime = Integer.parseInt(CreateDishEnterPreparationTime.getText());
//    System.out.println("User Input: " + createDishEnterDishID); // For demonstration: print it out
//
//}
//
//public void addDishesToDatabase(int DishesID,String Name, int RecipeID, String PhotoPath,int PreparationTime) {
//    String sql = "INSERT INTO Dishes WHERE DishID = ?AND Name=? AND RecipeID=? AND PhotoPath=? AND PreparationTime=?";
//    try (PreparedStatement statement = connection.prepareStatement(sql)) {
//        statement.setInt(1, DishesID);
//        statement.setString(2, Name);
//        statement.setInt(3, RecipeID);
//        statement.setString(4, PhotoPath);
//        statement.setInt(5, PreparationTime);
//        int rowsInserted = statement.executeUpdate();
//        if (rowsInserted > 0) {
//            System.out.println("Menu added successfully!");
//        } else {
//            System.out.println("Failed to add menu.");
//        }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//}
