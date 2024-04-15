package com.example.javateamproject;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreationController {
    @FXML
    private Button signinButton;
    @FXML
    private ImageView chefImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView signinImage;

    @FXML
    private TableColumn<users,Integer> col_RecipeId;

    @FXML
    private TableColumn<users,String> col_FoodName;

    @FXML
    private TableColumn<users,String> col_desc;

    @FXML
    private TableColumn<users,String> col_name;

    @FXML
    private TableColumn<users,String> col_status;

    @FXML

    private TableView<users>table_recipe;



//    @FXML
//    private TableColumn<users, Integer> col_RecipeId;
//
//    @FXML
//    private TableColumn<users, String> col_name;
//
//    @FXML
//    private TableColumn<users, LocalDate> col_weekstartdate;
//
//    @FXML
//    private TableView<users> table_users;

//    @FXML
//    private TableColumn<>

    @FXML
    private TextField keywordTextField;

    ObservableList<users> listM;



    Connection conn = null;

    ResultSet rs = null;

    PreparedStatement pst = null;




    public void initialize() {
        // Checks if user is already signed in when page is loaded.
        checkSignedIn();
        col_RecipeId.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));

        col_FoodName.setCellValueFactory(new PropertyValueFactory<users,String>("FoodName"));

        col_desc.setCellValueFactory(new PropertyValueFactory<users,String>("description"));

        col_name.setCellValueFactory(new PropertyValueFactory<users,String>("Name"));

        col_status.setCellValueFactory(new PropertyValueFactory<users,String>("Status"));




        listM = SqlConnection.getDatausers();
        table_recipe.setItems(listM);

        FilteredList<users> filteredData = new FilteredList<>(listM, b->true);

        keywordTextField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredData.setPredicate(users -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                String specificKeyword = newValue.toLowerCase();

                if(users.getName().toLowerCase().indexOf(specificKeyword) > -1){
                    return true;
                } else if (String.valueOf(users.getId()).toLowerCase().indexOf(specificKeyword) > -1) {
                    return true;
                } else if(users.getFoodName().toLowerCase().indexOf(specificKeyword) > -1){
                    return true;
                } else if(users.getDescription().toLowerCase().indexOf(specificKeyword) > -1){
                    return true;
                }

                else
                    return false;
            });
        });

        SortedList<users> sortedData = new SortedList<>(filteredData);

        //update table with sorted result and bind it
        sortedData.comparatorProperty().bind(table_recipe.comparatorProperty());

        table_recipe.setItems(sortedData);
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
}
