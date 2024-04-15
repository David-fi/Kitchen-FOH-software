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
import java.sql.DriverManager;
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
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password ="3h058sqxPaI";


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
        addDishesToDatabase(createDishEnterDishID, createDishEnterDishName, createDishEnterRecipeID, createDishEnterPhotoPath, createDishEnterPreparationTime);


    }

        public void addDishesToDatabase(int DishesID,String Name, int RecipeID, String PhotoPath,int PreparationTime) {


            String sql = "INSERT INTO Dishes (DishID, Name, RecipeID, PhotoPath, PreparationTime) VALUES (?, ?, ?, ?, ?)";

            try {Connection connection=null;
                 connection=DriverManager.getConnection(url,user,password);
                    PreparedStatement statement = connection.prepareStatement(sql);{
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
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

