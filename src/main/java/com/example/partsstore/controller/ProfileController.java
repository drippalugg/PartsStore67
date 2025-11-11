package com.example.partsstore.controller;

import com.example.partsstore.model.User;
import com.example.partsstore.service.SupabaseAuthService;
import com.example.partsstore.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfileController {

    @FXML private Label nameLabel;
    @FXML private Label emailLabel;

    private SupabaseAuthService authService;

    @FXML
    public void initialize() {
        authService = new SupabaseAuthService();
        loadUserData();
    }

    private void loadUserData() {
        User user = authService.getCurrentUser();
        if (user != null) {
            nameLabel.setText(user.getName());
            emailLabel.setText(user.getEmail());
        }
    }

    @FXML
    private void logout() {
        authService.logout();
        SceneManager.loadScene("main");
    }

    @FXML
    private void goBack() {
        SceneManager.loadScene("main");
    }
}
