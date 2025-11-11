package com.example.partsstore.controller;

import com.example.partsstore.service.SupabaseAuthService;
import com.example.partsstore.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nameField;
    @FXML private Label errorLabel;
    @FXML private javafx.scene.layout.VBox registerBox;

    private SupabaseAuthService authService;
    private boolean isRegisterMode = false;

    @FXML
    public void initialize() {
        authService = new SupabaseAuthService();
        registerBox.setVisible(false);
        registerBox.setManaged(false);
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showError("Заполните все поля");
            return;
        }

        boolean success = authService.login(email, password);

        if (success) {
            SceneManager.loadScene("main");
        } else {
            showError("Неверный email или пароль");
        }
    }

    @FXML
    private void handleRegister() {
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String name = nameField.getText().trim();

        if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            showError("Заполните все поля");
            return;
        }

        if (password.length() < 6) {
            showError("Пароль должен содержать минимум 6 символов");
            return;
        }

        boolean success = authService.register(email, password, name);

        if (success) {
            SceneManager.loadScene("main");
        } else {
            showError("Ошибка регистрации. Возможно, email уже используется");
        }
    }

    @FXML
    private void toggleMode() {
        isRegisterMode = !isRegisterMode;
        registerBox.setVisible(isRegisterMode);
        registerBox.setManaged(isRegisterMode);
        errorLabel.setText("");
    }

    @FXML
    private void guestContinue() {
        SceneManager.loadScene("main");
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: red;");
    }

    @FXML
    private void goBack() {
        SceneManager.loadScene("main");
    }
}
