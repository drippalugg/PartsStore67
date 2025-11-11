package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FavoritesWindow extends VBox {
    public FavoritesWindow(Stage stage, User user, MainScreen mainScreen) {
        setPadding(new Insets(20));
        setSpacing(12);

        Button backBtn = new Button("Назад");
        backBtn.setOnAction(e -> mainScreen.openMainScreen());

        Label label = new Label("Избранное");
        label.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");

        getChildren().addAll(backBtn, label);
    }
}

