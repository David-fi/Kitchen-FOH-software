package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class OrderController {
    @FXML
    private Button signinButton;
    @FXML
    private ImageView chefImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView signinImage;
    @FXML
    private Button table1Button;
    @FXML
    private Button table2Button;
    @FXML
    private Button table3Button;
    @FXML
    private Button table4Button;
    @FXML
    private Button table5Button;
    @FXML
    private Button table6Button;
    @FXML
    private Button table7Button;
    @FXML
    private Button table8Button;
    @FXML
    private Button table9Button;
    @FXML
    private Button table10Button;
    @FXML
    private Button table11Button;
    @FXML
    private Button table12Button;
    @FXML
    private Button table13Button;
    @FXML
    private Button table14Button;
    @FXML
    private Button table15Button;
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";
    private Map<Button,Integer> buttonTableMap = new HashMap<>();
    private List<Integer> tablePendingOrders = new ArrayList<>();

    public void initialize() {
        // Checks if user is already signed in when page is loaded.
        checkSignedIn();
        buttonTableMap.put(table1Button, 1);
        buttonTableMap.put(table2Button, 2);
        buttonTableMap.put(table3Button, 3);
        buttonTableMap.put(table4Button, 4);
        buttonTableMap.put(table5Button, 5);
        buttonTableMap.put(table6Button, 6);
        buttonTableMap.put(table7Button, 7);
        buttonTableMap.put(table8Button, 8);
        buttonTableMap.put(table9Button, 9);
        buttonTableMap.put(table10Button, 10);
        buttonTableMap.put(table11Button, 11);
        buttonTableMap.put(table12Button, 12);
        buttonTableMap.put(table13Button, 13);
        buttonTableMap.put(table14Button, 14);
        buttonTableMap.put(table15Button, 15);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                retrieveOrderedTables();
                changeTableColor();
            }
        }, 0, 15 * 1000);
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

    private void retrieveOrderedTables() {
        try {
            tablePendingOrders.clear();
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT DISTINCT TableID FROM Orders WHERE Status = 'Pending'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tablePendingOrders.add(resultSet.getInt("TableID"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void changeTableColor() {
        for (Button button : buttonTableMap.keySet()) {
            Integer tableID = buttonTableMap.get(button);
            if (tablePendingOrders.contains(tableID)) {
                button.setStyle("-fx-background-color: linear-gradient(to right bottom, #42E695, #32B2B8);");
            } else {
                button.setStyle("-fx-background-color: transparent");
            }
        }
    }
    public void showTable1Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("1");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable2Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("2");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable3Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("3");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable4Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("4");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable5Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("5");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable6Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("6");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable7Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("7");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable8Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("8");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable9Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("9");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable10Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("10");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable11Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("11");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showTable12Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("12");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable13Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("13");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable14Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("14");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showTable15Window() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-order.fxml"));
            Parent root = loader.load();
            TableOrderController controller = loader.getController();
            controller.setTableNumber("15");
            controller.getOrders();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
