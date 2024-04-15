module com.example.javateamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.httpserver;
    requires java.desktop;
    requires BOHLibrary;


    opens com.example.javateamproject to javafx.fxml;
    exports com.example.javateamproject;

}
