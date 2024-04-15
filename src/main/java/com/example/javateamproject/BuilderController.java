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

public class BuilderController {
    @FXML
    private Button signinButton;
    @FXML
    private ImageView chefImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView signinImage;

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

    public void switchToCreateRecipe(ActionEvent event) throws IOException {
        // Switches to create recipe page.
        if (LoginController.type != null && ("Chef".equals(LoginController.type) || "Sous".equals(LoginController.type) || "Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("create-recipe-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToDeleteRecipe(ActionEvent event) throws IOException {
        // Switches to delete recipe page.
        if (LoginController.type != null && ("Sous".equals(LoginController.type) || "Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("delete-recipe-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToUpdateRecipe(ActionEvent event) throws IOException {
        // Switches to update recipe page.
        if (LoginController.type != null && ("Chef".equals(LoginController.type) || "Sous".equals(LoginController.type) || "Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("update-recipe-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToCreateDish(ActionEvent event) throws IOException {
        // Switches to create dish page.
        if (LoginController.type != null && ("Chef".equals(LoginController.type) || "Sous".equals(LoginController.type) || "Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("create-dish-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToDeleteDish(ActionEvent event) throws IOException {
        // Switches to delete dish page.
        if (LoginController.type != null && ("Sous".equals(LoginController.type) || "Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("delete-dish-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToUpdateDish(ActionEvent event) throws IOException {
        // Switches to update dish page.
        if (LoginController.type != null && ("Chef".equals(LoginController.type) || "Sous".equals(LoginController.type) || "Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("update-dish-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToCreateMenu(ActionEvent event) throws IOException {
        // Switches to create menu page.
        if (LoginController.type != null &&("Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("create-menu-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToDeleteMenu(ActionEvent event) throws IOException {
        // Switches to delete menu page.
        if (LoginController.type != null &&("Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("delete-menu-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToUpdateMenu(ActionEvent event) throws IOException {
        // Switches to update menu page.
        if (LoginController.type != null &&("Head".equals(LoginController.type))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("update-menu-page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            try {
                showAlertWindow("You do not have the right permissions.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
    public void showAlertWindow (String message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("alert.fxml"));
            Parent root = loader.load();
            AlertController controller = loader.getController();
            controller.setMessage(message);
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
