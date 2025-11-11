package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartWindow extends VBox {
    public CartWindow(Stage stage, User user, MainScreen mainScreen) {
        setPadding(new Insets(20));
        setSpacing(12);

        Button backBtn = new Button("Назад");
        backBtn.setOnAction(e -> mainScreen.openMainScreen());

        Label label = new Label("Ваша корзина");
        label.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");

        getChildren().addAll(backBtn, label);
    }
}
