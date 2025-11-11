package com.example.partsstore;

import com.example.partsstore.model.User;
import com.example.partsstore.view.AuthWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        AuthWindow authWindow = new AuthWindow(stage);
        Scene scene = new Scene(authWindow, 400, 300);

        stage.setScene(scene);
        stage.setTitle("MasterParts - Вход");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
