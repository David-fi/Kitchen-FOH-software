package com.example.javateamproject;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import java.net.URL;
import java.sql.Connection;
import java.sql.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import FinalInterTeamServices.BOH.BOHDataAccessor;
import FinalInterTeamServices.BOH.BOHFinalInterface;
import model.Ingredient;
import java.util.List;


public class TrackingController{
    @FXML
    private Button signinButton;
    @FXML
    private ImageView chefImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView signinImage;
    @FXML
    private TableColumn<WasteEntry, Integer> col_id;
    @FXML
    private TableColumn<WasteEntry, Integer> col_ingredients_id;
    @FXML
    private TableColumn<WasteEntry, Double> col_quantity;
    @FXML
    private TableColumn<WasteEntry, String> col_reason;
    @FXML
    private TableColumn<WasteEntry, LocalDate> col_date_logged;
    @FXML
    private TableView<WasteEntry> table_users;
    @FXML
    private TextField keywordTextField;
    ObservableList<WasteEntry> listW;
    @FXML
    private TableView<Ingredient> stockTableView;
    @FXML
    private TableColumn<Ingredient, Integer> ingredientIdColumn;
    @FXML
    private TableColumn<Ingredient, String> nameColumn;
    @FXML
    private TableColumn<Ingredient, Double> costColumn;
    @FXML
    private TableColumn<Ingredient, Integer> quantityColumn;
    @FXML
    private TableColumn<Ingredient, Integer> thresholdColumn;
    private final BOHFinalInterface bohDataAccessor = new BOHDataAccessor();

    public void initialize() {
        // Checks if user is already signed in when page is loaded.
        checkSignedIn();
        col_id.setCellValueFactory(new PropertyValueFactory<WasteEntry, Integer>("wasteID"));
        col_ingredients_id.setCellValueFactory(new PropertyValueFactory<WasteEntry, Integer>("ingredientID"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<WasteEntry, Double>("quantity"));
        col_reason.setCellValueFactory(new PropertyValueFactory<WasteEntry, String>("reason"));
        col_date_logged.setCellValueFactory(new PropertyValueFactory<WasteEntry, LocalDate>("dateLogged"));

        listW = SqlConnection.getWasteData();
        table_users.setItems(listW);
        FilteredList<WasteEntry> filteredData = new FilteredList<>(listW, b->true);

// Set up table columns
        ingredientIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIngredientID()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
        thresholdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getThreshold()).asObject());

        // Get stock levels and populate the table view
        List<Ingredient> stockLevels = bohDataAccessor.getStockLevels();
        stockTableView.getItems().addAll(stockLevels);

    }

    public void switchToHome(ActionEvent event) throws IOException {
        // Switches to home page.
        Parent root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddWaste(ActionEvent event) throws IOException {
        // Switches to add waste page.
        Parent root = FXMLLoader.load(getClass().getResource("add-waste-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDeleteWaste(ActionEvent event) throws IOException {
        // Switches to add waste page.
        Parent root = FXMLLoader.load(getClass().getResource("delete-waste-page.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEditWaste(ActionEvent event) throws IOException {
        // Switches to add waste page.
        Parent root = FXMLLoader.load(getClass().getResource("edit-waste-page.fxml"));
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













