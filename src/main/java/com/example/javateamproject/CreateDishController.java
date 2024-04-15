package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateDishController {

    @FXML
    private TextArea CreateDishEnterDishID;
    @FXML
    private TextField CreateDishEnterDishName;
    @FXML
    private TextArea CreateDishEnterRecipeID;
    @FXML
    private TextField CreateDishEnterPhotoPath;
    @FXML
    private TextField CreateDishEnterPreparationTime;
    public Connection connection;
    @FXML
    private Button signinButton;
    @FXML
    private ImageView chefImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView signinImage;

    /* public CreateDishController(Connection connection) {
        this.connection = connection; //To implement a connection
    } */
    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    public void handleSave() {
        int createDishEnterDishID = Integer.parseInt(CreateDishEnterDishID.getText());// Get the text from TextArea
        String createDishEnterDishName = CreateDishEnterDishName.getText();
        int createDishEnterRecipeID = Integer.parseInt(CreateDishEnterRecipeID.getText());
        String createDishEnterPhotoPath = CreateDishEnterPhotoPath.getText();
        int createDishEnterPreparationTime = Integer.parseInt(CreateDishEnterPreparationTime.getText());
        System.out.println("User Input: " + createDishEnterDishID); // For demonstration: print it out

    }

        public void addDishesToDatabase(int DishesID,String Name, int RecipeID, String PhotoPath,int PreparationTime) {
            String sql = "INSERT INTO Dishes WHERE DishID = ?AND Name=? AND RecipeID=? AND PhotoPath=? AND PreparationTime=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, DishesID);
                statement.setString(2, Name);
                statement.setInt(3, RecipeID);
                statement.setString(4, PhotoPath);
                statement.setInt(5, PreparationTime);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Menu added successfully!");
                } else {
                    System.out.println("Failed to add menu.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //addDishesToDatabase(createDishEnterDishID, createDishEnterDishName, createDishEnterRecipeID, createDishEnterPhotoPath, createDishEnterPreparationTime);
    }

