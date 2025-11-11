module com.example.partsstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;

    opens com.example.partsstore to javafx.fxml;
    exports com.example.partsstore;
    exports com.example.partsstore.service;
    opens com.example.partsstore.service to javafx.fxml;
    exports com.example.partsstore.model;
    opens com.example.partsstore.model to javafx.fxml;
    exports com.example.partsstore.view;
    opens com.example.partsstore.view to javafx.fxml;
}