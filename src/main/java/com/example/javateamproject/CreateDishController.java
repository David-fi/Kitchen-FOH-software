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

    public CreateDishController(Connection connection) {
        this.connection = connection; //To implement a connection
    }
    public void initialize() {
        // Checks if user is already signed in when page is loaded.
        checkSignedIn();
    }

    public void switchToHome(ActionEvent event) throws IOException {
        // Switches to home page.
        Parent root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOrder(ActionEvent event) throws IOException {
        // Switches to order page.
        Parent root = FXMLLoader.load(getClass().getResource("order-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreation(ActionEvent event) throws IOException {
        // Switches to creation page.
        Parent root = FXMLLoader.load(getClass().getResource("creation-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBuilder(ActionEvent event) throws IOException {
        // Switches to builder page.
        Parent root = FXMLLoader.load(getClass().getResource("builder-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTracking(ActionEvent event) throws IOException {
        // Switches to tracking page.
        Parent root = FXMLLoader.load(getClass().getResource("tracking-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDiscussion(ActionEvent event) throws IOException {
        // Switches to discussion page.
        Parent root = FXMLLoader.load(getClass().getResource("discussion-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToReview(ActionEvent event) throws IOException {
        // Switches to review page.
        Parent root = FXMLLoader.load(getClass().getResource("review-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showLoginWindow(ActionEvent event) throws IOException {
        // Shows login page in a new window.
        if (signinButton.getText().equals("Sign in")){
            // When sign in is pressed.
            Parent root = FXMLLoader.load(getClass().getResource("sign-in.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            if(LoginController.id != null && LoginController.username != null && LoginController.type != null){
                usernameLabel.setText(LoginController.username + ":" + LoginController.id + "(" + LoginController.type + ")");
                if (LoginController.type.equals("Chef")){
                    chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Chef.png")));
                }
                else if (LoginController.type.equals("Sous")){
                    chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Sous.png")));
                }
                else if (LoginController.type.equals("Head")){
                    chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Head.png")));
                }
                signinButton.setText("Sign out");
                signinImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Logout.png")));
            }
        }
        else if (signinButton.getText().equals("Sign out")){
            // When sign out is pressed.
            LoginController.clearLogin();
            usernameLabel.setText("You are not signed in");
            chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Unsigned.png")));
            signinButton.setText("Sign in");
            signinImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Login.png")));
        }
    }

    public void checkSignedIn() {
        // Check if user is signed in
        if (LoginController.id != null && LoginController.username != null && LoginController.type != null) {
            usernameLabel.setText(LoginController.username + ":" + LoginController.id + "(" + LoginController.type + ")");
            if (LoginController.type.equals("Chef")) {
                chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Chef.png")));
            }
            else if (LoginController.type.equals("Sous")) {
                chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Sous.png")));
            }
            else if (LoginController.type.equals("Head")) {
                chefImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Head.png")));
            }
            signinButton.setText("Sign out");
            signinImage.setImage(new Image(getClass().getResourceAsStream("/com/example/javateamproject/StyleElements/Logout.png")));
        }
    }

    public void switchToSignIn(ActionEvent actionEvent) {
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

