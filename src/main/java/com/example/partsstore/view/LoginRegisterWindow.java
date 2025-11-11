package com.example.partsstore.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import com.example.partsstore.service.SupabaseClient;

public class LoginRegisterWindow extends VBox {
    public LoginRegisterWindow() {
        setPadding(new Insets(15));
        setSpacing(10);

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Пароль");

        Button loginBtn = new Button("Войти");
        Button registerBtn = new Button("Регистрация");
        Label statusLabel = new Label();

        loginBtn.setOnAction(e -> {
            boolean result = SupabaseClient.login(emailField.getText(), passwordField.getText());
            statusLabel.setText(result ? "Вход выполнен" : "Ошибка авторизации");
            // По успешному входу — открыть CatalogWindow
        });

        registerBtn.setOnAction(e -> {
            boolean result = SupabaseClient.register(emailField.getText(), passwordField.getText());
            statusLabel.setText(result ? "Регистрация успешна" : "Ошибка регистрации");
        });

        getChildren().addAll(emailField, passwordField, loginBtn, registerBtn, statusLabel);
    }
}
