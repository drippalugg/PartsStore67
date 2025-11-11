package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FavoritesWindow extends VBox {
    private Stage stage;
    private User currentUser;

    public FavoritesWindow(Stage stage, User user) {
        this.stage = stage;
        this.currentUser = user;

        setPadding(new Insets(20));
        setSpacing(12);

        Label title = new Label("Избранные товары");
        title.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");

        Button backBtn = new Button("Назад");
        backBtn.setOnAction(e -> {
            MainScreen main = new MainScreen(stage, currentUser);
            stage.setScene(new Scene(main, 1300, 800));
            stage.setTitle("MasterParts");
        });

        getChildren().addAll(title, backBtn);
    }
}
