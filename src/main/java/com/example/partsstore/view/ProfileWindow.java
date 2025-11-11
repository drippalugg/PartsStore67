package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProfileWindow extends VBox {

    public ProfileWindow(javafx.stage.Stage stage, User user) {
        setPadding(new Insets(20));
        setSpacing(12);

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

        getChildren().addAll(emailLabel, firstNameField, lastNameField, phoneField, saveButton);
    }
}
