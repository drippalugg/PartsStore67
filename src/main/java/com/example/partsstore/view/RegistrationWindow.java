package com.example.partsstore.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationWindow extends VBox {
    private Stage stage;

    public RegistrationWindow(Stage stage) {
        this.stage = stage;

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Пароль");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Подтвердите пароль");

        Button registerButton = new Button("Зарегистрироваться");
        Label messageLabel = new Label();

        registerButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                messageLabel.setText("Пожалуйста, заполните все поля");
                return;
            }
            if (!password.equals(confirmPassword)) {
                messageLabel.setText("Пароли не совпадают");
                return;
            }

            // Здесь поместите логику сохранения данных регистрации
            messageLabel.setText("Регистрация успешна!");

            // Можно добавить переход к окну авторизации
        });

        setSpacing(10);
        setPadding(new Insets(20));
        getChildren().addAll(emailField, passwordField, confirmPasswordField, registerButton, messageLabel);
    }
}
