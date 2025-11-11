package com.example.partsstore.util;

import com.example.partsstore.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneManager {

    public static void loadScene(String fxmlName) {
        try {
            String fxmlPath = "/com/example/partsstore/view/" + fxmlName + ".fxml";
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            String cssPath = "/com/example/partsstore/css/styles.css";
            var cssUrl = SceneManager.class.getResource(cssPath);
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }

            MainApp.getPrimaryStage().setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
