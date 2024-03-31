module com.example.javateamproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javateamproject to javafx.fxml;
    exports com.example.javateamproject;
}