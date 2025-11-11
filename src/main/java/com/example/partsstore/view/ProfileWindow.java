package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileWindow extends VBox {
    public ProfileWindow(Stage stage, User user, MainScreen mainScreen) {
        setPadding(new Insets(20));
        setSpacing(12);

        Button backButton = new Button("Назад");
        backButton.setOnAction(e -> mainScreen.openMainScreen());

        Label emailLabel = new Label("Email: " + user.getEmail());
        TextField firstNameField = new TextField(user.getFirstName());
        firstNameField.setPromptText("Имя");
        TextField lastNameField = new TextField(user.getLastName());
        lastNameField.setPromptText("Фамилия");
        TextField phoneField = new TextField(user.getPhone());
        phoneField.setPromptText("Телефон");

        Button saveButton = new Button("Сохранить изменения");
        saveButton.setOnAction(e -> {
            user.setFirstName(firstNameField.getText());
            user.setLastName(lastNameField.getText());
            user.setPhone(phoneField.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Данные сохранены");
            alert.showAndWait();
        });

        getChildren().addAll(backButton, emailLabel, firstNameField, lastNameField, phoneField, saveButton);
    }
}
