package com.example.partsstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        try {
            primaryStage = stage;
            primaryStage.setTitle("MasterParts - Магазин автозапчастей");
            primaryStage.setWidth(1280);
            primaryStage.setHeight(800);

            String fxmlPath = "/com/example/partsstore/view/main.fxml";
            System.out.println("🔍 Поиск FXML файла: " + fxmlPath);

            URL fxmlUrl = getClass().getResource(fxmlPath);
            if (fxmlUrl == null) {
                System.err.println(" FXML файл НЕ НАЙДЕН: " + fxmlPath);
                throw new IOException("FXML файл не найден: " + fxmlPath);
            }

            System.out.println(" FXML найден: " + fxmlUrl);

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            System.out.println(" Загрузка FXML...");

            Parent root = loader.load();
            System.out.println(" FXML загружен успешно");

            Scene scene = new Scene(root);

            String cssPath = "/com/example/partsstore/css/styles.css";
            URL cssUrl = getClass().getResource(cssPath);

            if (cssUrl != null) {
                System.out.println(" CSS найден: " + cssUrl);
                scene.getStylesheets().add(cssUrl.toExternalForm());
            } else {
                System.out.println("️ CSS не найден (необязательно): " + cssPath);
            }

            primaryStage.setScene(scene);
            primaryStage.show();

            System.out.println(" Приложение успешно запущено!");

        } catch (IOException e) {
            System.err.println(" ОШИБКА при загрузке FXML:");
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            System.err.println(" НЕОЖИДАННАЯ ОШИБКА:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
