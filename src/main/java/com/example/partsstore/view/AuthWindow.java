package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AuthWindow extends VBox {
    private Stage stage;

    public AuthWindow(Stage stage) {
        this.stage = stage;

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Пароль");

        Button loginBtn = new Button("Войти");
        Label messageLabel = new Label();

        loginBtn.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Заполните поля");
                return;
            }

            // Эмулируем успешную авторизацию
            User user = new User(email, "Иван", "Иванов", "+7 900 123-45-67");
            openMainScreen(user);
        });

        setSpacing(10);
        setPadding(new javafx.geometry.Insets(20));
        getChildren().addAll(emailField, passwordField, loginBtn, messageLabel);
    }

    private void openMainScreen(User user) {
        Platform.runLater(() -> {
            MainScreen mainScreen = new MainScreen(stage, user);
            Scene scene = new Scene(mainScreen, 1300, 800);
            stage.setScene(scene);
            stage.setTitle("MasterParts");
        });
    }
}
